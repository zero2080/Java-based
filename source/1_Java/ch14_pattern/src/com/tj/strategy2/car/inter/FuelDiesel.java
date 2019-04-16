package com.tj.strategy2.car.inter;

public class FuelDiesel implements IFuel{

	@Override
	public void fuel() {
		System.out.println("경유로 움직입니다");
	}

}
