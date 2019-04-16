package com.tj.strategy1.step4.inter;

public class MissileNo implements IMissile{

	@Override
	public void missile() {
		System.out.println("미사일을 쏠 수 없습니다");
	}
	
}
