package com.tj.ex02thread;

public class ThreadEx extends Thread{
	@Override
	public void run() {
		super.run();
		String name = Thread.currentThread().getName();
		System.out.println("쓰레드명:"+name);
		System.out.println("클래스명: ThreadEx");
		for(int i=0 ; i<10 ; i++) {
			System.out.println(name+" : i="+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}
