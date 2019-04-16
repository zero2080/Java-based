package com.tj.strategy1.step4.modularization;
//날 수 X. 미사일을 쏠 수 X. 검 없음.
import com.tj.strategy1.step4.inter.*;
public class LowRobot extends Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	public LowRobot() {
		fly = new FlyNo();
		missile = new MissileNo();
		knife = new KnifeNo();
	}
	@Override
	public void actionFly() {
		fly.fly();
	}
	@Override
	public void actionMissile() {
		missile.missile();
	}
	@Override
	public void actionKnife() {
		knife.knife();
	}
}
