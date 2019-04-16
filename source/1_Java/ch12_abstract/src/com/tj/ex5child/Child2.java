package com.tj.ex5child;
//main에서 new Child1(500,700,100,500,400,150)
//        new Child2(500,700,100,500,400,150)
public class Child2 extends LunchMenu {
	private String type="Child2형 식대";
	public Child2() {}
	public Child2(int rice, int bulgogi, int soup, int banana, int milk, int almond) {
		super(rice, bulgogi, soup, banana, milk, almond);
	}
	@Override
	public int calculate() {
		return getRice()+getBulgogi()+getSoup()+getMilk()+getAlmond();
	}
	public String getType() {return type;}
}
