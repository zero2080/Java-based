package com.tj.ex06toy;

public class MazingerToyClass implements IMissile, IMoveArmLeg {
	public MazingerToyClass() {
		System.out.println("마징가 Z입니다");
		canMoveArmLeg();
		canMissile();
		System.out.println("---------------");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일 수 있다");
	}
	@Override
	public void canMissile() {
		System.out.println("미사일을 쏠 수 있다");
	}
}
