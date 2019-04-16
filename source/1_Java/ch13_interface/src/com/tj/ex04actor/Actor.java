package com.tj.ex04actor;
public class Actor implements Chef, Policeman, FireFighter{
	private String name;
	public Actor() {}
	public Actor(String name) {
		this.name = name;
	}
	@Override
	public void makePizza() {
		System.out.println(name+"�� ���ڸ� ������");
	}
	@Override
	public void makeSpaghetti() {
		System.out.println(name+"�� ���İ�Ƽ�� ������");
	}
	@Override
	public void canCatchCriminal() {
		System.out.println(name+"�� ������ ��ƿ�");
	}
	@Override
	public void canSearch() {
		System.out.println(name+"�� ����� ã�ƿ�");
	}
	@Override
	public void outFire() {
		System.out.println(name+"�� ���� ����");
	}
	@Override
	public void saveMan() {
		System.out.println(name+"�� ����� ���ؿ�");
	}
}