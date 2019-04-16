package com.tj.ex7vote;
import java.util.Random;
public class VoteThread implements Runnable{
	private int count; //개표율
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
			sb.delete(0, sb.length()); // sb를 ""로 바꾸는 작업
			if(count>=LIMIT) {
				count = 100;
				for(int i=0 ; i<count ; i++) {
					sb.append('*');
				}
				System.out.println(Thread.currentThread().getName()+"개표율 : "+count
						+"%\t"+sb);
				break;
			}else {
				for(int i=0 ; i<count ; i++) {
					sb.append('*');
				}
				System.out.println(Thread.currentThread().getName()+"개표율 : "+count
						+"%\t"+sb);
			}//if
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}//while
	}//run
}//class








