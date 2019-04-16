package com.tj.ex5sync;

public class ThreadEx implements Runnable{
	private int num=0; // ���� �����峢�� ������ ����
	@Override
	public synchronized void run() {
		String threadName = Thread.currentThread().getName();
		for(int i=0 ; i<10 ; i++) {
			if(threadName.equals("A")) {
				num++;
				System.out.println("~ ~ A ���� �� ~ ~");
			}
			System.out.println(threadName+"�� num : "+num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}
	}
	public int getNum() {
		return num;
	}
}
