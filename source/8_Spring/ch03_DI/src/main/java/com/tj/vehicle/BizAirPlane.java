package com.tj.vehicle;

public class BizAirPlane extends Airplane {
	
	@Override
	public void ride(String name) {
		// TODO Auto-generated method stub
		super.ride(name);
		System.out.println("비즈니스석에서 안락하게 간다");
	}
}
