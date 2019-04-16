package com.tj.ex3_account;
public class Account {
	private String accountNo; // ���¹�ȣ
	private String name; // ������ �̸�
	private int balance;      // �ܾ�
	public Account(String accountNo, String name, int balance) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
		System.out.println(name+"�� "+balance+"������ ���¿��°����մϴ�");
	}
	public Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
		System.out.println(name+"�� ������ ���¿��� �� ����");
	}
	public void deposit(int money) {
		if(money<0) {
			System.out.println("���� �ݾ� ���� �Ұ�");
		}else {
			balance += money;
		}
	}
	public void withdraw(int money) {
		if(balance<money) {
			System.out.println("�ܾ��� �����Ͽ� ���� �Ұ�");
			return;
		}
		balance -= money; // balance = balance - money;
	}
	public String getAccountNo() {return accountNo;}
	public void setAccountNo(String accountNo) {this.accountNo = accountNo;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getBalance() {return balance;}
	public void setBalance(int balance) {this.balance = balance;}
}








