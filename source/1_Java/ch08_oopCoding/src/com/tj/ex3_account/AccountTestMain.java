package com.tj.ex3_account;

public class AccountTestMain {
	public static void main(String[] args) {
		Account hong = new Account("110-999-1","ȫ�浿");
		Account kang = new Account("120-999-2","���浿",20000);
		hong.deposit(-30000);
		System.out.println("hong�� �ܾ� : "+hong.getBalance());
		hong.deposit(10000);
		System.out.println("hong�� �ܾ� : "+hong.getBalance());
		kang.withdraw(30000);
	}
}
