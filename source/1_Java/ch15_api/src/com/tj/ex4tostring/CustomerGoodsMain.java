package com.tj.ex4tostring;

public class CustomerGoodsMain {
	public static void main(String[] args) {
		Goods[] goods = {new Goods("a01", "�����", 1200, 100),
				new Goods("b01","���ִ¿���",5000,5)	};
		Customer[] cs = {new Customer("010-9999-9999", "ȫ�浿"),
				new Customer("02-888-8888", "���浿")};
		for(Goods g : goods) {
			System.out.println(g);
		}
		for(Customer c: cs) {
			System.out.println(c);
		}
	}
}
