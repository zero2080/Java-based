package com.tj.ex8_Product;

public class Product {
	public static int count = 100; // °øÀ¯
	public int serialNo;
	public Product() {
		serialNo = ++count;
	}
}
