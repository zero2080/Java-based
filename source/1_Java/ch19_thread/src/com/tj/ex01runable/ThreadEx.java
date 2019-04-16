package com.tj.ex01runable;

public class ThreadEx implements Runnable {
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName);
		System.out.println("ThreadEx");
		for(int i=0 ; i<10 ; i++) {
			System.out.println(threadName +" : i="+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}

}
