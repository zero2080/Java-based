package com.tj.strategy1.step5.modularization;
//�� �� X. �̻����� �� �� X. �� ����.
import com.tj.strategy1.step4.inter.*;
public class LowRobot extends Robot {
	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
		//fly = new FlyNo();
		//missile = new MissileNo();
		//knife = new KnifeNo();
	}
}
