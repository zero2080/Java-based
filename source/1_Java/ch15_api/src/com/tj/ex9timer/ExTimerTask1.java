package com.tj.ex9timer;

import java.util.TimerTask;

public class ExTimerTask1 extends TimerTask{
	@Override
	public void run() { // 작업을 여기에 정의
		System.out.println("작업1 task 실행 중");
	}
}
