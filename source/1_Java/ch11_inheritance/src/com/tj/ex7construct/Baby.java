package com.tj.ex7construct;
public class Baby extends Person {
	public Baby() {
		System.out.println("�Ű����� ���� Baby ������");
	}
	public Baby(String name, String character) {
		System.out.println("�Ű����� �ִ� Baby ������");
		setName(name);
		setCharacter(character);
	}
	@Override
	public void intro() {
		System.out.println(getName()+"�� �Ʊ�� �� ����");
	}
	public void cry() {
		System.out.println("��������");
	}
}
