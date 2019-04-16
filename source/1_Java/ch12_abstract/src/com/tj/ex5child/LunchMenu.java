package com.tj.ex5child;
public abstract class LunchMenu {
	private int rice;
	private int bulgogi;
	private int soup;
	private int banana;
	private int milk;
	private int almond;
	public LunchMenu() {}
	public LunchMenu(int rice, int bulgogi, int soup, int banana, int milk, int almond) {
		this.rice = rice;	this.bulgogi = bulgogi;
		this.soup = soup;   this.banana = banana;
		this.milk = milk;   this.almond = almond;
	}
	public abstract int calculate(); // 식대계산하는 method 강제 override 하도록
	public abstract String getType();
	//main에서 new Child1(500,700,100,500,400,150)
	//        new Child2(500,700,100,500,400,150)
	public int getRice() {return rice;}
	public int getBulgogi() {return bulgogi;}
	public int getSoup() {return soup;}
	public int getBanana() {return banana;}
	public int getMilk() {return milk;}
	public int getAlmond() {return almond;}
}
















