package com.tj.ex06toy;
public class PoohToyClass implements IMoveArmLeg{
	public PoohToyClass() {
		System.out.println("������ Ǫ�Դϴ�");
		canMoveArmLeg();
		System.out.println("------------------");
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ִ�");
	}
}
