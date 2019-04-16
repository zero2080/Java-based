package com.tj.ex7_person;
public class Person {
	private String name;
	private int money;        // 개인돈
	public static int COMM_MONEY; // 회사돈
	public Person(String name) {//main에서 Person p = new Person("홍길동")
		this.name = name;
	}
	public void saveMoney(int money) {
		this.money += money; // this.money = this.money+money;
	}
	public void currentMoney() {
		System.out.println(name+"의 개인자신 : "+money);
		System.out.println("공용 자산 : "+COMM_MONEY);
	}
}
