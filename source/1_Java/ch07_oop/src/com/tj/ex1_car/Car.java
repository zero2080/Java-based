package com.tj.ex1_car;
// ������ - ����, ��ⷮ, �귻��, �ӵ� 
// �޼ҵ� - ����̺�, ����, ���̽�
public class Car {
	private String color;
	private int cc;
	private String brand;
	private int speed;
	public void drive() {
		speed = 60;System.out.println(speed+"km/h �ӵ��� �����Ѵ�");
	}
	public void parking() {
		speed = 0;System.out.println("�����ߴ�. �ӵ��� "+speed+"km/h");
	}
	public void race() {
		speed = 100;System.out.println(speed+"km/h �ӵ��� ���̽��Ѵ�");
	}
	public void setColor(String color) {//main���� my.color="red"(x) my.setColor("red")
		this.color = color;
	}
	public void setCc(int cc) {//main���� my.cc = 1500(X) my.setCc(1500)
		this.cc = cc;
	}
	public void setBrand(String brand) {//main���� my.brand="HD"(X) my.setBrand("HD")
		this.brand = brand;
	}
	public void setSpeed(int speed) {//main���� my.speed=60(X)   my.setSpeed(60)
		this.speed = speed;
	}
	public String getColor() { // my.color(X) my.getColor()
		return color;
	}
	public int getCc() {// my.cc(X)    my.getCc()
		return cc;
	}
	public String getBrand() {// my.brand(X) my.getBrand()
		return brand;
	}
	public int getSpeed() {// my.speed(X) my.getSpeed()
		return speed;
	}
}









