package com.tj.ex2throws;

public class MainClass {
	public static void main(String[] args) {
		try {
			new ThrowEx();
		} catch (Exception e) {
			System.out.println("����ó�� main���� ��");
		}
	}
}
