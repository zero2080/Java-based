package com.tj.ex5_pouch;
public class MainClass {
	public static void main(String[] args) {
		System.out.println("�Ƶ��� �������� �� :"+MomPouch.MONEY);
		Child c1 = new Child("ù°�ʸ���");
		Child c2 = new Child("��°������");
		Child c3 = new Child("��°�����");
		c1.takeMoney(100);
		c2.takeMoney(100);
		c3.takeMoney(100);
		System.out.println("�Ƶ鿡�� �� �� �� : "+MomPouch.MONEY);
	}
}
