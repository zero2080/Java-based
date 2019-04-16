package com.tj.ex4shape;
public class Triangle extends Shape{
	private int w;
	private int h;
	public Triangle() {}
	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
		setKind("»ï°¢Çü");
	}
	@Override
	public String getStringArea() {
		return "»ï°¢Çü ³ĞÀÌ´Â "+(w*h*0.5);
	}
	@Override
	public double getArea() {
		return w*h*0.5;
	}
	@Override
	public void area() {
		System.out.println("¹Øº¯("+w+"), ³ôÀÌ("+h+")ÀÇ »ï°¢Çü ³ĞÀÌ´Â "+(w*h/2));
	}
	@Override
	public void draw() {
		System.out.print("»ï°¢Çü ");super.draw();		
	}
}
