package com.tj.ex5_pouch;
public class Child {
	//MomPouch momPouch = new MomPouch();
	private String name;
	public Child(String name) {//main���� Child c1 = new Child("ù°�ʸ���")
		this.name = name;
	}
	public void takeMoney(int money) {
		if(MomPouch.MONEY >= money) {
			MomPouch.MONEY -= money;
			System.out.println(name+"�� "+money+"�� ������");
		}else{
			System.out.println(name+"�� ���� �� �޾�. ������ ���� ����");
		}
	}
}
