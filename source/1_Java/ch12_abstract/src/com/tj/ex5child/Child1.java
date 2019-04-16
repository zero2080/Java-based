package com.tj.ex5child;
//main에서 new Child1(500,700,100,500,400,150)
//        new Child2(500,700,100,500,400,150)
public class Child1 extends LunchMenu{
	private String type="child1형 식대";
	public Child1() {}
	public Child1(int rice, int bulgogi, int soup, int banana, int milk, int almond) {
		super(rice, bulgogi, soup, banana, milk, almond);
	}
	@Override
	public int calculate() {
		return getRice()+getBulgogi()+getSoup()+getBanana();
	}
	public String getType() {
		return type;
	}
}
