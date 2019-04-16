package com.tj.strategy1.step5.modularization;
import com.tj.strategy1.step4.inter.FlyNo;
import com.tj.strategy1.step4.inter.IFly;
import com.tj.strategy1.step4.inter.IKnife;
import com.tj.strategy1.step4.inter.IMissile;
import com.tj.strategy1.step4.inter.KnifeWood;
import com.tj.strategy1.step4.inter.MissileYes;
//날 수 X. 미사일을 쏠 수 O. 목검
public class StandardRobot extends Robot {
	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
		//fly = new FlyNo();
		//missile = new MissileYes();
		//knife = new KnifeWood();
	}
}
