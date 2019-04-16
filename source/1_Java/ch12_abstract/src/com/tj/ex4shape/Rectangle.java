package com.tj.ex4shape;
public class Rectangle extends Shape {
	private int w;
	private int h;
	public Rectangle() {}
	public Rectangle(int w, int h) {//main에서 Rectangle r = new Rectangle(3,4)
		this.w = w;
		this.h = h;
		setKind("사각형");
	}	
	@Override
	public String getStringArea() {
		return "사각형 넓이는 "+(w*h);
	}
	@Override
	public double getArea() {
		return w*h;
	}
	@Override
	public void area() {
		System.out.println("가로("+w+"), 세로("+h+")인 사각형의 넓이는 "+(w*h));
	}
}
