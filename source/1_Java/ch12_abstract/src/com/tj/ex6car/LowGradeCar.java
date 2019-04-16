package com.tj.ex6car;
//main에서 LowGradeCar c1 = new LowGradeCar("레드", "일반타이어", 2000, "파워핸들);
public class LowGradeCar extends Car {
	private int tax;
	public LowGradeCar() {}
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		tax = 50000;
	}
	@Override
	public void getSpec() {
		if(getDisplacement()>=1000) {
			tax += (getDisplacement()-1000)*500;
		}
		System.out.println("******************");
		System.out.println("색  상 : "+getColor());
		System.out.println("타이어 : "+getTire());
		System.out.println("배기량 : "+getDisplacement()+"cc");
		System.out.println("핸  들 : "+getHandle());
		System.out.println("세  금 : "+tax);
	}
}
