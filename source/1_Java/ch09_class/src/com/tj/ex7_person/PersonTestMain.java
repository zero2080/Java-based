package com.tj.ex7_person;
public class PersonTestMain {
	public static void main(String[] args) {
		Person p1 = new Person("ȫ�浿");
		Person p2 = new Person("�ű浿");
		Person p3 = new Person("�̱浿");
		p1.saveMoney(1000); Person.COMM_MONEY+=1000;
		p2.saveMoney(1000); Person.COMM_MONEY+=1000;
		p3.saveMoney(3000); Person.COMM_MONEY+=3000;
		p1.currentMoney(); p2.currentMoney(); p3.currentMoney();
		
	}
}
