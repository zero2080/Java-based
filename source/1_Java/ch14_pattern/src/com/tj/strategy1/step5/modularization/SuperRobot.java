package com.tj.strategy1.step5.modularization;
import com.tj.strategy1.step4.inter.*;
public class SuperRobot extends Robot{
	public SuperRobot() {
		//fly = new FlyYes();
		setFly(new FlyYes());
		//missile = new MissileYes();
		setMissile(new MissileYes());
		// knife = new KnifeLazer();
		setKnife(new KnifeLazer());
	}
	
}
