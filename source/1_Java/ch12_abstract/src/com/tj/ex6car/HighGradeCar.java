package com.tj.ex6car;
//main에서 HighGradeCar c1 = new HighGradeCar("레드", "일반타이어", 2000, "파워핸들");
public class HighGradeCar extends Car {
	private int tax;
	public HighGradeCar() {}
	public HighGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		tax = 100000;
	}
	@Override
	public void getSpec() {
		if(getDisplacement()>=2000) {
			tax += (getDisplacement()-2000)*1000;
		}
		System.out.println("******************");
		System.out.println("색  상 : "+getColor());
		System.out.println("타이어 : "+getTire());
		System.out.println("배기량 : "+getDisplacement()+"cc");
		System.out.println("핸  들 : "+getHandle());
		System.out.println("세  금 : "+tax);
	}
}
