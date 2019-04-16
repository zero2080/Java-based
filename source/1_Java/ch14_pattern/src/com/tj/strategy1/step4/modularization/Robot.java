package com.tj.strategy1.step4.modularization;

public abstract class Robot {
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}
	public void actionRun() {
		System.out.println("달릴 수 있습니다.");
	}
	public void shape() {
		System.out.println(getClass().getName()+"은 팔,다리,몸통,머리가 있어요");
	}
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
}
