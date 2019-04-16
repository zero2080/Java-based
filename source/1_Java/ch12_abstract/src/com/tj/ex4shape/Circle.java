package com.tj.ex4shape;
public class Circle extends Shape{
	private int r; //반지름
	public Circle() {}
	public Circle(int r) {
		this.r = r;
		setKind("원");
	}
	@Override
	public void area() {
		System.out.println("반지름이 "+r+"인 원의 넓이는 "+(3.14*r*r));
	}
	@Override
	public void draw() {System.out.println("원을 이쁘게 그려요");}
	@Override
	public String getStringArea() {
		return "원의 넓이는 "+(r*r*3.14);
	}
	@Override
	public double getArea() {return r*r*3.14;}
}
