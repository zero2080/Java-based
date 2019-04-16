package com.tj.strategy1.step1;
/*��� �κ��� �⺻������ �Ȱ�, �޸� �� �־�� �մϴ�.
�κ� ����� ��, �ٸ�, �Ӹ�, �������� �̷���� �ֽ��ϴ�.
Low    �κ� : �� �� X. �̻����� �� �� X. �� ���� */
public class LowRobot {
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�");
	}
	public void actionRun() {
		System.out.println("�޸� �� �ֽ��ϴ�");
	}
	public void shape() {
		System.out.println(getClass().getName()+"�� ��, �ٸ�, �Ӹ�, ���밡 �־�� ");
	}
	public void actionFly() {
		System.out.println("�� �� �����ϴ�");
	}
	public void actionMissile() {
		System.out.println("�������� �� �� �����ϴ�");
	}
	public void actionKnife() {
		System.out.println("���� �����ϴ�");
	}
}
