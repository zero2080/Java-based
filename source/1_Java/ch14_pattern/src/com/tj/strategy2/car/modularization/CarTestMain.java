package com.tj.strategy2.car.modularization;

public class CarTestMain {
	public static void main(String[] args) {
		Genesis car0 = new Genesis();
		Sonata  car1 = new Sonata();
		Accent  car2 = new Accent();
		Car[] car = {car0, car1, car2};
		for(Car c : car) {
			c.shape();
			c.drive();
			c.isEngine();
			c.isKm();
			c.isFuel();
		}
	}
}
