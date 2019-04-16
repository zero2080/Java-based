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
		System.out.println("LowRobot의 검을 목검으로 교체한다");
		lowRobot.setKnife(new KnifeWood());
		lowRobot.actionKnife();
		System.out.println("SuperRobot의 나는 부품을 교체(멀리높이멋있게나는부품)");
		superRobot.setFly(new FlyHigh());
		superRobot.actionFly();
	}
}













