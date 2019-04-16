package com.tj.strategy2.car.inter;

public class FuelGasoline implements IFuel {

	@Override
	public void fuel() {
		System.out.println("휘발유로 움직입니다");
	}

}
