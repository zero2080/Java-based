package com.tj.strategy1.step2;
/*모든 로봇은 기본적으로 걷고, 달릴 수 있어야 합니다.
로봇 모양은 팔, 다리, 머리, 몸통으로 이루어져 있습니다.
Super  로봇 : 날 수 O. 미사일을 쏠 수 O. 레이저검*/
public class SuperRobot extends Robot{
	public void actionFly() {
		System.out.println("날 수 있습니다");
	}
	public void actionMissile() {
		System.out.println("마사일을 쏠 수 있습니다");
	}
	public void actionKnife() {
		System.out.println("레이저 검이 있습니다");
	}
}
