package com.tj.ex02thread;

public class ThreadExTest {
	public static void main(String[] args) {
		Thread threadA = new ThreadEx();
		threadA.setName("A");
		threadA.start();
		Thread threadB = new ThreadEx();
		threadB.setName("B");
		threadB.start(); // 3���� �����尡 ���ÿ� ����
		System.out.println("main�Լ��� ������ �̸�:"+Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		System.out.println("main�Լ� �� - - - ");
	}
}
