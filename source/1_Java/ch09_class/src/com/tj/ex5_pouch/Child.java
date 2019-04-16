package com.tj.ex5_pouch;
public class Child {
	//MomPouch momPouch = new MomPouch();
	private String name;
	public Child(String name) {//main에서 Child c1 = new Child("첫째똘만이")
		this.name = name;
	}
	public void takeMoney(int money) {
		if(MomPouch.MONEY >= money) {
			MomPouch.MONEY -= money;
			System.out.println(name+"가 "+money+"원 가져감");
		}else{
			System.out.println(name+"가 돈을 못 받아. 엄마가 돈이 없대");
		}
	}
}
