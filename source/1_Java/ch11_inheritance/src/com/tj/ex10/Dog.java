package com.tj.ex10;

public final class Dog extends Animal{
	@Override
	public void running() {
		// speed += 10;
		setSpeed(getSpeed()+10);
		super.running();
	}
}
