package com.tj.strategy1.step3;
//2´Ü°è
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
		}//for
	}
}
