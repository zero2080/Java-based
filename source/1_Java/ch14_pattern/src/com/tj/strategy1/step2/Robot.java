package com.tj.strategy1.step2;

public class Robot {
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�");
	}
	public void actionRun() {
		System.out.println("�޸� �� �ֽ��ϴ�");
	}
	public void shape() {
		System.out.println(getClass().getName()+"�� ��, �ٸ�, �Ӹ�, ���밡 �־�� ");
	}
}
