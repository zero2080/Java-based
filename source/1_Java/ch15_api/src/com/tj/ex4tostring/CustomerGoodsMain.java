package com.tj.ex4tostring;

public class CustomerGoodsMain {
	public static void main(String[] args) {
		Goods[] goods = {new Goods("a01", "億辦條", 1200, 100),
				new Goods("b01","蛻氈朝辦嶸",5000,5)	};
		Customer[] cs = {new Customer("010-9999-9999", "�垮瘚�"),
				new Customer("02-888-8888", "葆望翕")};
		for(Goods g : goods) {
			System.out.println(g);
		}
		for(Customer c: cs) {
			System.out.println(c);
		}
	}
}
