package com.tj.ex7_person;
public class Person {
	private String name;
	private int money;        // ���ε�
	public static int COMM_MONEY; // ȸ�絷
	public Person(String name) {//main���� Person p = new Person("ȫ�浿")
		this.name = name;
	}
	public void saveMoney(int money) {
		this.money += money; // this.money = this.money+money;
	}
	public void currentMoney() {
		System.out.println(name+"�� �����ڽ� : "+money);
		System.out.println("���� �ڻ� : "+COMM_MONEY);
	}
}
