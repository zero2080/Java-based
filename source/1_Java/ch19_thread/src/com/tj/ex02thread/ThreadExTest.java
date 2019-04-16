package com.tj.ex02thread;

public class ThreadExTest {
	public static void main(String[] args) {
		Thread threadA = new ThreadEx();
		threadA.setName("A");
		threadA.start();
		Thread threadB = new ThreadEx();
		threadB.setName("B");
		threadB.start(); // 3개의 쓰레드가 동시에 수행
		System.out.println("main함수의 쓰레드 이름:"+Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		System.out.println("main함수 끝 - - - ");
	}
}
