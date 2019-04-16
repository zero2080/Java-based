package com.tj.ex5_pouch;
public class MainClass {
	public static void main(String[] args) {
		System.out.println("아들이 가져가기 전 :"+MomPouch.MONEY);
		Child c1 = new Child("첫째똘만이");
		Child c2 = new Child("둘째갑돌이");
		Child c3 = new Child("셋째길똥이");
		c1.takeMoney(100);
		c2.takeMoney(100);
		c3.takeMoney(100);
		System.out.println("아들에게 돈 준 후 : "+MomPouch.MONEY);
	}
}
