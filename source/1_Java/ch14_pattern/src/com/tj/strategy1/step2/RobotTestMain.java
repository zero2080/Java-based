package com.tj.strategy1.step2;
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
			if(robot instanceof SuperRobot) {
				SuperRobot sr = (SuperRobot)robot;
				sr.actionFly();
				sr.actionMissile();
				sr.actionKnife();
			}else if(robot instanceof StandardRobot) {
				StandardRobot sr = (StandardRobot)robot;
				sr.actionFly();
				sr.actionMissile();
				sr.actionKnife();
			}else if(robot instanceof LowRobot) {
				LowRobot lr = (LowRobot)robot;
				lr.actionFly();
				lr.actionMissile();
				lr.actionKnife();
			}
			
		}
	}
}
