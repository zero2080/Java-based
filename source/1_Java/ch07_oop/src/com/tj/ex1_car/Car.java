package com.tj.ex1_car;
// 데이터 - 색상, 배기량, 브렌드, 속도 
// 메소드 - 드라이브, 주차, 레이싱
public class Car {
	private String color;
	private int cc;
	private String brand;
	private int speed;
	public void drive() {
		speed = 60;System.out.println(speed+"km/h 속도로 운전한다");
	}
	public void parking() {
		speed = 0;System.out.println("주차했다. 속도는 "+speed+"km/h");
	}
	public void race() {
		speed = 100;System.out.println(speed+"km/h 속도로 레이싱한다");
	}
	public void setColor(String color) {//main에서 my.color="red"(x) my.setColor("red")
		this.color = color;
	}
	public void setCc(int cc) {//main에서 my.cc = 1500(X) my.setCc(1500)
		this.cc = cc;
	}
	public void setBrand(String brand) {//main에서 my.brand="HD"(X) my.setBrand("HD")
		this.brand = brand;
	}
	public void setSpeed(int speed) {//main에서 my.speed=60(X)   my.setSpeed(60)
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









