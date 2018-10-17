package io.dama.par.dining.cond;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.Random;

public class Philosopher extends Thread implements IPhilosopher {
	private IPhilosopher left, right;
	private Lock table;
	public Condition isNotEating;
	volatile private boolean isNotStopped = true;
	volatile Thread selfPhilosopher = this;
	private Random random = new Random();
	private int eatCounter = 0;
	private boolean atBeginning = true;
	public volatile boolean eating = false;

	@Override
	public void setLeft(final IPhilosopher left) {
		this.left = left;

	}

	@Override
	public void setRight(final IPhilosopher right) {
		this.right = right;
	}

	@Override
	public void setTable(final Lock table) {
		this.table = table;
		isNotEating = table.newCondition(); // Verstößt vermutlich gegen alle
		// Programmierprinzipien
	}

	@Override
	public void stopPhilosopher() {
		System.out.println(this.getName() + "Gegessen:" + this.eatCounter);
		isNotStopped = false;
		selfPhilosopher.interrupt();
	}

	@Override
	public void run() {

		while (isNotStopped) {

			try {
				think();
			} catch (InterruptedException e) {
			}
			try {
				eat();
			} catch (InterruptedException e) {
			}
		}
	}

	private void think() throws InterruptedException {
		System.out.println(this.getName() + " Gebe Signal");
		Thread.sleep(this.random.nextInt(PhilosopherExperiment.MAX_THINKING_DURATION_MS));
	}

	private void eat() throws InterruptedException {
		table.lock();
		try {
			if (atBeginning) {
				atBeginning = false;
			} else {
				((Philosopher) left).isNotEating.await();
				((Philosopher) right).isNotEating.await();
			}
			System.out.println(this.getName() + " Esse");
			eating = true;
			if (((Philosopher) left).eating || ((Philosopher) right).eating)
				System.out.println("FEHLER");
			this.eatCounter++;
			Thread.sleep(PhilosopherExperiment.MAX_EATING_DURATION_MS);
			System.out.println(this.getName() + " Beende Essen");
			eating = false;
			this.isNotEating.signalAll();
		} finally {
			table.unlock();
		}
	}
}
