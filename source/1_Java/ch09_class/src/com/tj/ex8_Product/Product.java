package com.tj.ex8_Product;

public class Product {
	public static int count = 100; // ����
	public int serialNo;
	public Product() {
		serialNo = ++count;
	}
}
