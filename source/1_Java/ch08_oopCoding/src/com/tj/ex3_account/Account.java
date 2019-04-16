package com.tj.ex3_account;
public class Account {
	private String accountNo; // 계좌번호
	private String name; // 예금주 이름
	private int balance;      // 잔액
	public Account(String accountNo, String name, int balance) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
		System.out.println(name+"님 "+balance+"원으로 계좌오픈감사합니다");
	}
	public Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
		System.out.println(name+"님 돈없이 계좌오픈 뭐 감사");
	}
	public void deposit(int money) {
		if(money<0) {
			System.out.println("음수 금액 예금 불가");
		}else {
			balance += money;
		}
	}
	public void withdraw(int money) {
		if(balance<money) {
			System.out.println("잔액이 부족하여 인출 불가");
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








