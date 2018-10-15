package io.dama.par.dining.cond;

import java.util.concurrent.locks.Lock;

public class Philosopher extends Thread implements IPhilosopher {

    private Philosopher left;
    private Philosopher right;
    private Lock table;
    
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
    	    	
    	System.out.println(getId() + " starts eating.");
    	
    	if(getRight().isAlive()||getLeft().isAlive())
			// das funktioniert noch nicht
    		System.out.println(getId() + " is Interrupted.");
    	
    	while(getRight().isAlive()||getLeft().isAlive()){
    			// das funktioniert noch nicht
    	}
    	
    	System.out.println(getId() + " finished.");
    }

	public Philosopher getRight() {
		return right;
	}

	public Philosopher getLeft() {
		return left;
	}
}
