package com.tj.ex01runable;

public class ThreadExTestMain {
	public static void main(String[] args) {
		ThreadEx targetThread = new ThreadEx();
		Thread threadA = new Thread(targetThread, "A");
		Thread threadB = new Thread(targetThread, "B");
		threadA.start(); // 실행가능한 쓰레드
		threadB.start();
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) { }
		System.out.println("main() 완료");
	}
}
