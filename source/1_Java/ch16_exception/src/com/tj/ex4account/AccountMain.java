package com.tj.ex4account;

public class AccountMain {
	public static void main(String[] args) {
		Account kim = new Account("180-1", "��浿");
		Account hong = new Account("180-9", "ȫ�浿",1000);
		System.out.println(kim);
		System.out.println(hong);
		try {
			kim.deposit(-1000);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		try {
			hong.withdraw(1500);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
