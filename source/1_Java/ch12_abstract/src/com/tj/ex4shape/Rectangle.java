package com.tj.ex4shape;
public class Rectangle extends Shape {
	private int w;
	private int h;
	public Rectangle() {}
	public Rectangle(int w, int h) {//main���� Rectangle r = new Rectangle(3,4)
		this.w = w;
		this.h = h;
		setKind("�簢��");
	}	
	@Override
	public String getStringArea() {
		return "�簢�� ���̴� "+(w*h);
	}
	@Override
	public double getArea() {
		return w*h;
	}
	@Override
	public void area() {
		System.out.println("����("+w+"), ����("+h+")�� �簢���� ���̴� "+(w*h));
	}
}
