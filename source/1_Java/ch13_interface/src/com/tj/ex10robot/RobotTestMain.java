package com.tj.ex10robot;

public class RobotTestMain {
	public static void main(String[] args) {
		RobotOrder order = new RobotOrder(); // �Ͻ�Ű�� ��ü
		DanceRobot danceRobot = new DanceRobot();
		order.order(danceRobot);//danceRobot���� order
		DrawRobot drawRobot = new DrawRobot();
		SingRobot singRobot = new SingRobot();
		Robot[] robots = {danceRobot, drawRobot, singRobot};
		for(Robot robot : robots) {
			order.order(robot);
		}
	}
}