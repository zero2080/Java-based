package com.tj.ex06toy;

public class MazingerToyClass implements IMissile, IMoveArmLeg {
	public MazingerToyClass() {
		System.out.println("��¡�� Z�Դϴ�");
		canMoveArmLeg();
		canMissile();
		System.out.println("---------------");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ִ�");
	}
	@Override
	public void canMissile() {
		System.out.println("�̻����� �� �� �ִ�");
	}
}
