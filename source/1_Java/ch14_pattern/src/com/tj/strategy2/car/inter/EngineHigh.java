package com.tj.strategy2.car.inter;

public class EngineHigh implements IEngine {
	@Override
	public void engine() {
		System.out.println("최고급 엔진입니다");
	}
}
