package com.tj.strategy2.car.inter;
public class EngineLow implements IEngine {
	@Override
	public void engine() {
		System.out.println("저급엔진");
	}
}
