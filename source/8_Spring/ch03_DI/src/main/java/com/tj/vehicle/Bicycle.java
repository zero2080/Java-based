package com.tj.vehicle;

public class Bicycle implements Vehicle{
	@Override
	public void ride(String name) {
		System.out.println(name+"은(는) 자전거를 10km/h 속도로 탄다");
	}
}
