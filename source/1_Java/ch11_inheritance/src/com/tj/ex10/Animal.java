package com.tj.ex10;
public class Animal {
	private int speed;
	public void running() {
		speed += 5;
		System.out.println("�ٰ� �־��. ���� �ӵ� : "+speed);
	}
	public final void stop() {
		speed = 0;
		System.out.println("����!");
	}
	public int getSpeed() {return speed;}
	public void setSpeed(int speed) {this.speed = speed;}
}
