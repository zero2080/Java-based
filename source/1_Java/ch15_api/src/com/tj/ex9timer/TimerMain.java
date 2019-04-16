package com.tj.ex9timer;
import java.util.Timer;
public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		ExTimerTask1 task1 = new ExTimerTask1();
		ExTimerTask2 task2 = new ExTimerTask2();
		
		Timer timer = new Timer(true);
						//main함수가 끝날때까지만 timer구동
		timer.schedule(task1, 2000);// 2초후에 task1.run()
		timer.schedule(task2, 500, 500);// 0.5초후부터 0.5초마다 task2.run()
		Thread.sleep(10000);
		System.out.println("DONE");
	}
}
