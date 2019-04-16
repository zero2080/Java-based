package com.tj.strategy1.step3;
/*모든 로봇은 기본적으로 걷고, 달릴 수 있어야 합니다.
로봇 모양은 팔, 다리, 머리, 몸통으로 이루어져 있습니다.
Low    로봇 : 날 수 X. 미사일을 쏠 수 X. 검 없음 */
public class LowRobot extends Robot{
	@Override
	public void actionFly() {
		System.out.println("날 수 없습니다");
	}
	@Override
	public void actionMissile() {
		System.out.println("마사일을 쏠 수 없습니다");
	}
	@Override
	public void actionKnife() {
		System.out.println("검이 없습니다");
	}
}
