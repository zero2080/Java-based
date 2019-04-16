package com.tj.strategy1.step2;

public class Robot {
	public void actionWalk() {
		System.out.println("걸을 수 있습니다");
	}
	public void actionRun() {
		System.out.println("달릴 수 있습니다");
	}
	public void shape() {
		System.out.println(getClass().getName()+"은 팔, 다리, 머리, 몸통가 있어요 ");
	}
}
