package com.tj.ex10robot;

public class RobotOrder {
	public void order(Robot robot) {
		if(robot instanceof DanceRobot) {//robot이 DanceRobot형 객체
			DanceRobot dr = (DanceRobot)robot;
			dr.dance();
		}else if(robot instanceof DrawRobot) {
			DrawRobot dr = (DrawRobot) robot;
			dr.draw();
		}else if(robot instanceof SingRobot) {
			SingRobot sr = (SingRobot) robot;
			sr.sing();
		}else {
			System.out.println("현재는 명령이 정의되어 있지 않습니다");
		}
	}
}
