package com.tj.ex4objectNthreadN;

public class ThreadExtendCls extends Thread{
	private int num=0;
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for(int i=0; i<10 ; i++) {
			if(name.equals("A")) {
				num++;
				System.out.println("~ ~ A¼öÇàÁß ~ ~");
			}
			System.out.println(name+" : num="+num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}
	}
	public int getNum() {
		return num;
	}
}
