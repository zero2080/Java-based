package com.tj.ex6object_etc;

public class RectangleMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle(5, 6);
		Rectangle r2 = (Rectangle) r1.clone();
		if(r1==r2) {
			System.out.println("복제된게 아니고 같은 거네");
		}else {
			System.out.println("다른 주소네");
		}
		if(r1.equals(r2)) {
			System.out.println("같은 내용이네");
		}else {
			System.out.println("다른 내용이네");
		}
		System.out.println("r1 : "+r1);
		System.out.println("r2 : "+r2);
	}
}
