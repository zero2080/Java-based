package com.tj.ex06toy;
public class AirPlaneToyClass implements IMissile, ILight{
	public AirPlaneToyClass() {
		System.out.println("����� �峭���Դϴ�");
		canLight();
		canMissile();
		System.out.println("----------------------");
	}
	@Override
	public void canLight() {
		System.out.println("�Һ� �ݻ� �����մϴ�");
	}
	@Override
	public void canMissile() {
		System.out.println("������ �� �� �־��");
	}
}