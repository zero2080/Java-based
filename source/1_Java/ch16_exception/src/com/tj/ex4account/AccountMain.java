package com.tj.ex4account;

public class AccountMain {
	public static void main(String[] args) {
		Account kim = new Account("180-1", "±è±æµ¿");
		Account hong = new Account("180-9", "È«±æµ¿",1000);
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
