package com.tj.ex6atm;

public class ThreadATM implements Runnable{
	private int depositORwithdraw = 1;
	private ATM atm;
	public ThreadATM(ATM atm) {
		this.atm = atm;
	}
	@Override
	public void run() {
		for(int i=0 ; i<6 ; i++) {
			if(depositORwithdraw==1) {
				atm.deposit(5000, Thread.currentThread().getName());
				depositORwithdraw = 0;
			}else {
				atm.withdraw(4000, Thread.currentThread().getName());
				depositORwithdraw = 1;
			}//if
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}//for
	}//run
}//class
