package com.tj.ex1_square;

public class SquareTestMain {
	public static void main(String[] args) {
		Square s1 = new Square();
		Square s2 = new Square(10);
		s1.setSide(100);
		System.out.println(s1.getSide()+"������ ���簢������ : "+s1.area());
		System.out.println(s2.getSide()+"������ ���簢������ : "+s2.area());
	}
}
