package com.tj.strategy1.step2;
/*��� �κ��� �⺻������ �Ȱ�, �޸� �� �־�� �մϴ�.
�κ� ����� ��, �ٸ�, �Ӹ�, �������� �̷���� �ֽ��ϴ�.
Super  �κ� : �� �� O. �̻����� �� �� O. ��������*/
public class SuperRobot extends Robot{
	public void actionFly() {
		System.out.println("�� �� �ֽ��ϴ�");
	}
	public void actionMissile() {
		System.out.println("�������� �� �� �ֽ��ϴ�");
	}
	public void actionKnife() {
		System.out.println("������ ���� �ֽ��ϴ�");
	}
}
