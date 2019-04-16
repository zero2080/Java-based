package com.tj.ex10robot;

public class RobotOrder {
	public void order(Robot robot) {
		if(robot instanceof DanceRobot) {//robot�� DanceRobot�� ��ü
			DanceRobot dr = (DanceRobot)robot;
			dr.dance();
		}else if(robot instanceof DrawRobot) {
			DrawRobot dr = (DrawRobot) robot;
			dr.draw();
		}else if(robot instanceof SingRobot) {
			SingRobot sr = (SingRobot) robot;
			sr.sing();
		}else {
			System.out.println("����� ����� ���ǵǾ� ���� �ʽ��ϴ�");
		}
	}
}
