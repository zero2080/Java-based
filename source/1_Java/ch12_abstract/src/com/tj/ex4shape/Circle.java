package com.tj.ex4shape;
public class Circle extends Shape{
	private int r; //������
	public Circle() {}
	public Circle(int r) {
		this.r = r;
		setKind("��");
	}
	@Override
	public void area() {
		System.out.println("�������� "+r+"�� ���� ���̴� "+(3.14*r*r));
	}
	@Override
	public void draw() {System.out.println("���� �̻ڰ� �׷���");}
	@Override
	public String getStringArea() {
		return "���� ���̴� "+(r*r*3.14);
	}
	@Override
	public double getArea() {return r*r*3.14;}
}
