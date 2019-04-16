package com.tj.strategy1.step2;
/*��� �κ��� �⺻������ �Ȱ�, �޸� �� �־�� �մϴ�.
�κ� ����� ��, �ٸ�, �Ӹ�, �������� �̷���� �ֽ��ϴ�.
Low    �κ� : �� �� X. �̻����� �� �� X. �� ���� */
public class LowRobot extends Robot{
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