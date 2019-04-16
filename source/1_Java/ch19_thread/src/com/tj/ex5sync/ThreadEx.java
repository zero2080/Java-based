package com.tj.ex5sync;

public class ThreadEx implements Runnable{
	private int num=0; // 값을 쓰레드끼리 공유할 목적
	@Override
	public synchronized void run() {
		String threadName = Thread.currentThread().getName();
		for(int i=0 ; i<10 ; i++) {
			if(threadName.equals("A")) {
				num++;
				System.out.println("~ ~ A 수행 중 ~ ~");
			}
			System.out.println(threadName+"의 num : "+num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}
	}
	public int getNum() {
		return num;
	}
}
