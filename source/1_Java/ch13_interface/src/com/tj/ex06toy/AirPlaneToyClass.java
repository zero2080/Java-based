package com.tj.ex06toy;
public class AirPlaneToyClass implements IMissile, ILight{
	public AirPlaneToyClass() {
		System.out.println("비행기 장난감입니다");
		canLight();
		canMissile();
		System.out.println("----------------------");
	}
	@Override
	public void canLight() {
		System.out.println("불빛 반사 가능합니다");
	}
	@Override
	public void canMissile() {
		System.out.println("마사일 쏠 수 있어요");
	}
}