package com.tj.ex10;

public class Rabbit extends Animal{
	@Override
	public void running() {
		setSpeed(getSpeed()+20);
		super.running();
	}
}
