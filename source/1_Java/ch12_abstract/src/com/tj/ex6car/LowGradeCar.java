package com.tj.ex6car;
//main���� LowGradeCar c1 = new LowGradeCar("����", "�Ϲ�Ÿ�̾�", 2000, "�Ŀ��ڵ�);
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
		System.out.println("��  �� : "+getColor());
		System.out.println("Ÿ�̾� : "+getTire());
		System.out.println("��ⷮ : "+getDisplacement()+"cc");
		System.out.println("��  �� : "+getHandle());
		System.out.println("��  �� : "+tax);
	}
}
