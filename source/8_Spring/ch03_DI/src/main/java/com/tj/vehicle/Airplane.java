package com.tj.vehicle;

public class Airplane implements Vehicle {

	@Override
	public void ride(String name) {
		System.out.println(name+"은 비행기를 500km/h 속도로 간다");

	}

}
