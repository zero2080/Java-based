package com.tj.ex02thread;

public class ThreadEx extends Thread{
	@Override
	public void run() {
		super.run();
		String name = Thread.currentThread().getName();
		System.out.println("�������:"+name);
		System.out.println("Ŭ������: ThreadEx");
		for(int i=0 ; i<10 ; i++) {
			System.out.println(name+" : i="+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}
