package com.tj.ex2_rect;
public class RectTestMain {
	public static void main(String[] args) {
		Rect r1;
		r1 = new Rect();
		Rect r2 = new Rect();
		r1.setHeight(10); r1.setWidth(5); System.out.println(r1.area());
		r2.setHeight(10); r2.setWidth(5); System.out.println(r2.area());
		if(r1.equals(r2)) { // r1과 r2가 같은지 비교
			System.out.println("r1과 r2는 같은 객체네");
		}else {
			System.out.println("r1과 r2는 다른 객체네");
		}
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
	}
}
