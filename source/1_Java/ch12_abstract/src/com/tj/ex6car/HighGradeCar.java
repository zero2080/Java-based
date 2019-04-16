package com.tj.ex6car;
//main���� HighGradeCar c1 = new HighGradeCar("����", "�Ϲ�Ÿ�̾�", 2000, "�Ŀ��ڵ�");
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
		System.out.println("��  �� : "+getColor());
		System.out.println("Ÿ�̾� : "+getTire());
		System.out.println("��ⷮ : "+getDisplacement()+"cc");
		System.out.println("��  �� : "+getHandle());
		System.out.println("��  �� : "+tax);
	}
}
