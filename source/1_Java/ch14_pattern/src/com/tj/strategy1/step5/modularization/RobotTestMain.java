package com.tj.strategy1.step5.modularization;

import com.tj.strategy1.step4.inter.FlyHigh;
import com.tj.strategy1.step4.inter.KnifeWood;

public class RobotTestMain {

	public static void main(String[] args) {
		SuperRobot    superRobot    = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot      lowRobot      = new LowRobot();
		Robot[] robots = {superRobot, standardRobot, lowRobot};
		for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		System.out.println("LowRobot�� ���� ������� ��ü�Ѵ�");
		lowRobot.setKnife(new KnifeWood());
		lowRobot.actionKnife();
		System.out.println("SuperRobot�� ���� ��ǰ�� ��ü(�ָ����̸��ְԳ��º�ǰ)");
		superRobot.setFly(new FlyHigh());
		superRobot.actionFly();
	}
}













