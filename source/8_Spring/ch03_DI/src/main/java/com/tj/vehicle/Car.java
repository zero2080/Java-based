package com.tj.vehicle;

public class Car implements Vehicle{

	@Override
	public void ride(String name) {
		System.out.println(name+"는 자동차를 70km/h 속도로 간다");
	}

}
