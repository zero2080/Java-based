package com.tj.ex4account;
// Account kim = new Account("108-88","홍길동",2000)
// Account kim = new Account("108-88","홍길동")
public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	public Account() {}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	} // main에서 kim.deposit(2000);
	public void deposit(int amount) throws Exception{
		if(amount<0) {
			throw new Exception("음수 금액을 예금하려는 수상함이 보인다");
		}
		balance += amount;
		System.out.println(ownerName+"님 예금 감사합니다");
		System.out.println(this);
	}
	public void withdraw(int amount) throws Exception{
		if(balance<amount) {
			throw new Exception("잔액부족 예외");
		}
		balance -= amount;
		System.out.println(amount+"원 인출 성공");
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String result = "계좌번호:"+accountNo+", 예금주:"+ownerName
				+", 잔액:"+balance;
		return result;
	}
	
}
