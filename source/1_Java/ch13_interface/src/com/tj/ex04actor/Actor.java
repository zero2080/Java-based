package com.tj.ex04actor;
public class Actor implements Chef, Policeman, FireFighter{
	private String name;
	public Actor() {}
	public Actor(String name) {
		this.name = name;
	}
	@Override
	public void makePizza() {
		System.out.println(name+"은 피자를 만들어요");
	}
	@Override
	public void makeSpaghetti() {
		System.out.println(name+"은 스파게티를 만들어요");
	}
	@Override
	public void canCatchCriminal() {
		System.out.println(name+"은 범인을 잡아요");
	}
	@Override
	public void canSearch() {
		System.out.println(name+"은 사람을 찾아요");
	}
	@Override
	public void outFire() {
		System.out.println(name+"은 불을 꺼요");
	}
	@Override
	public void saveMan() {
		System.out.println(name+"은 사람을 구해요");
	}
}