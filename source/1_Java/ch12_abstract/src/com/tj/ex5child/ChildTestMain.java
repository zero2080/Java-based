package com.tj.ex5child;

public class ChildTestMain {
	public static void main(String[] args) {
		LunchMenu child1 = new Child1(PriceTable.RICE,PriceTable.BULGOGI,
				PriceTable.SOUP,PriceTable.BANANA,PriceTable.MILK,
				PriceTable.ALMOND);
		LunchMenu child2 = new Child2(PriceTable.RICE, PriceTable.BULGOGI, 
				PriceTable.SOUP,PriceTable.BANANA,PriceTable.MILK,
				PriceTable.ALMOND);
		LunchMenu[] child = {child1, child2};
		for(LunchMenu c : child) {
			System.out.println(c.getType()+c.calculate());
		}
	}
}
