package com.tj.ex9timer;
import java.util.Timer;
public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		ExTimerTask1 task1 = new ExTimerTask1();
		ExTimerTask2 task2 = new ExTimerTask2();
		
		Timer timer = new Timer(true);
						//main�Լ��� ������������ timer����
		timer.schedule(task1, 2000);// 2���Ŀ� task1.run()
		timer.schedule(task2, 500, 500);// 0.5���ĺ��� 0.5�ʸ��� task2.run()
		Thread.sleep(10000);
		System.out.println("DONE");
	}
}
