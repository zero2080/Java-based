package com.tj.strategy1.step5.modularization;
import com.tj.strategy1.step4.inter.IFly;
import com.tj.strategy1.step4.inter.IKnife;
import com.tj.strategy1.step4.inter.IMissile;
public class Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�޸� �� �ֽ��ϴ�.");
	}
	public void shape() {
		System.out.println(getClass().getName()+"�� ��,�ٸ�,����,�Ӹ��� �־��");
	}
	public void actionFly() { fly.fly();	}
	public void actionMissile() {missile.missile();	}
	public void actionKnife() {	knife.knife();}
	
	public void setFly(IFly fly) {this.fly = fly;}
	public void setMissile(IMissile missile) {this.missile = missile;}
	public void setKnife(IKnife knife) {this.knife = knife;}
}
