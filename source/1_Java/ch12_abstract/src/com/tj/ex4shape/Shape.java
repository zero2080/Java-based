package com.tj.ex4shape;
public abstract class Shape {
	private String kind;
	public abstract void area();
	public abstract String getStringArea();
	public abstract double getArea();
	public void draw() {
		System.out.println("������ �̻ڰ� �׷���");
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
}