package com.tj.ex3object1ThreadN;
public class Obejct1ThreadN {
	public static void main(String[] args) {
		ThreadEx target = new ThreadEx();
		Thread threadA = new Thread(target,"A");
		Thread threadB = new Thread(target,"B");
		threadA.start();
		threadB.start();
		System.out.println("main¿¡¼­ÀÇ num"+target.getNum());
		System.out.println("DONE");
	}
}
