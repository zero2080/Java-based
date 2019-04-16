package com.tj.ex7vote;
import java.util.Random;
public class VoteThread implements Runnable{
	private int count; //��ǥ��
	private Random random;
	private final int LIMIT = 100;
	public VoteThread() {
		//count = 0;
		random = new Random();
	}
	@Override
	public void run() {
		StringBuilder sb = new StringBuilder(); // ""
		while(true) {
			count += random.nextInt(10); // 0~9
			sb.delete(0, sb.length()); // sb�� ""�� �ٲٴ� �۾�
			if(count>=LIMIT) {
				count = 100;
				for(int i=0 ; i<count ; i++) {
					sb.append('*');
				}
				System.out.println(Thread.currentThread().getName()+"��ǥ�� : "+count
						+"%\t"+sb);
				break;
			}else {
				for(int i=0 ; i<count ; i++) {
					sb.append('*');
				}
				System.out.println(Thread.currentThread().getName()+"��ǥ�� : "+count
						+"%\t"+sb);
			}//if
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}//while
	}//run
}//class








