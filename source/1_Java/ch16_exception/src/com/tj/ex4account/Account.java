package com.tj.ex4account;
// Account kim = new Account("108-88","ȫ�浿",2000)
// Account kim = new Account("108-88","ȫ�浿")
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
	} // main���� kim.deposit(2000);
	public void deposit(int amount) throws Exception{
		if(amount<0) {
			throw new Exception("���� �ݾ��� �����Ϸ��� �������� ���δ�");
		}
		balance += amount;
		System.out.println(ownerName+"�� ���� �����մϴ�");
		System.out.println(this);
	}
	public void withdraw(int amount) throws Exception{
		if(balance<amount) {
			throw new Exception("�ܾ׺��� ����");
		}
		balance -= amount;
		System.out.println(amount+"�� ���� ����");
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String result = "���¹�ȣ:"+accountNo+", ������:"+ownerName
				+", �ܾ�:"+balance;
		return result;
	}
	
}
