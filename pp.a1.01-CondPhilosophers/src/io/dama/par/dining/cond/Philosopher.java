package io.dama.par.dining.cond;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Philosopher extends Thread implements IPhilosopher {

    private Philosopher left;
    private Philosopher right;
    private Lock table;
    private Condition canEat;
    private Condition canNotEat;
    // lock tables, give conditions
    // whilst eating await to get right condition
    
    public Philosopher(){
    	
    }
    
	@Override
    public void setLeft(final IPhilosopher left) {
        // TODO Auto-generated method stub
		this.left = (Philosopher) left;
    }

    @Override
    public void setRight(final IPhilosopher right) {
        // TODO Auto-generated method stub
    	this.right = (Philosopher) right;
    }

    @Override
    public void setTable(final Lock table) {
        // TODO Auto-generated method stub
    	this.table = table;
    }

    @Override
    public void stopPhilosopher() {
        // TODO Auto-generated method stub
    	System.out.println(getId() + " forced to stop.");
    	this.interrupt();
    }
    
    @Override
    public void run(){
    	// TODO ?
    }
    
    @Override
    public void start(){
    	// TODO Either start eat or think
    }

	public Philosopher getRight() {
		return right;
	}

	public Philosopher getLeft() {
		return left;
	}
	
	public void eat(){
		// eating requires resources
	}
	
	public void think(){
		// thinking requires no resources and signals being free
	}
}
