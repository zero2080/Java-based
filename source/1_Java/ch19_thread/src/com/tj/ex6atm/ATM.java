package com.tj.ex6atm;

public class ATM {
	private int balance;
	public ATM(int balance) {
		this.balance = balance;
	}
	public synchronized void deposit(int amount, String who) {
		System.out.println("�ڡ�"+who+"�� �Ա� ���� �ڡ�");
		balance += amount;
		System.out.println(amount+"�� �Ա��Ͽ� �ܾ��� "+balance);
		System.out.println("�ڡ�"+who+"�� �Ա� �� �ڡ�");
	}
	public synchronized void withdraw(int amount, String who) {
		System.out.println("���"+who+"�� ��� ���� ���");
		balance -= amount;
		System.out.println(amount+"�� ����Ͽ� �ܾ��� "+balance);
		System.out.println("���"+who+"�� ��� �� ���");
	}
}
