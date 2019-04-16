package com.tj.ex7_person;
public class PersonTestMain {
	public static void main(String[] args) {
		Person p1 = new Person("홍길동");
		Person p2 = new Person("신길동");
		Person p3 = new Person("이길동");
		p1.saveMoney(1000); Person.COMM_MONEY+=1000;
		p2.saveMoney(1000); Person.COMM_MONEY+=1000;
		p3.saveMoney(3000); Person.COMM_MONEY+=3000;
		p1.currentMoney(); p2.currentMoney(); p3.currentMoney();
		
	}
}
