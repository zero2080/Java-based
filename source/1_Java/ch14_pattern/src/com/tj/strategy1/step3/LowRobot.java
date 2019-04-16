package com.tj.strategy1.step3;
/*��� �κ��� �⺻������ �Ȱ�, �޸� �� �־�� �մϴ�.
�κ� ����� ��, �ٸ�, �Ӹ�, �������� �̷���� �ֽ��ϴ�.
Low    �κ� : �� �� X. �̻����� �� �� X. �� ���� */
public class LowRobot extends Robot{
	@Override
	public void actionFly() {
		System.out.println("�� �� �����ϴ�");
	}
	@Override
	public void actionMissile() {
		System.out.println("�������� �� �� �����ϴ�");
	}
	@Override
	public void actionKnife() {
		System.out.println("���� �����ϴ�");
	}
}
