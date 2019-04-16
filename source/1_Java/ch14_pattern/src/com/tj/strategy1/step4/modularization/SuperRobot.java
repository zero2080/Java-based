package com.tj.strategy1.step4.modularization;
import com.tj.strategy1.step4.inter.*;
public class SuperRobot extends Robot{
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	public SuperRobot() {
		fly = new FlyYes();
		missile = new MissileYes();
		knife = new KnifeLazer();
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
