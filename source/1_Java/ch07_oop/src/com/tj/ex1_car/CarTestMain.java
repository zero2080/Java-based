package com.tj.ex1_car;
public class CarTestMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		Car yourPorsche = new Car();
		myPorsche.setColor("black");
		yourPorsche.setCc(1500);
		System.out.println("myPorsche ���� :"+myPorsche.getColor()+"/"
		  +myPorsche.getBrand()+"/"+myPorsche.getCc()+myPorsche.getSpeed());
		System.out.println("yourPorsche ���� :"+yourPorsche.getColor()+"/"
		  +yourPorsche.getBrand()+"/"+yourPorsche.getCc()+yourPorsche.getSpeed());
		myPorsche.drive();
		myPorsche.parking();
		yourPorsche.drive();
		System.out.println("myPorsche ���� :"+myPorsche.getColor()+"/"
			+myPorsche.getBrand()+"/"+myPorsche.getCc()+myPorsche.getSpeed());
		System.out.println("yourPorsche ���� :"+yourPorsche.getColor()+"/"
			+yourPorsche.getBrand()+"/"+yourPorsche.getCc()+yourPorsche.getSpeed());
	}
}
