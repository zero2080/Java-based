package com.tj.ex4objectNthreadN;

import com.tj.ex3object1ThreadN.ThreadEx;

public class ObjectNthreaN {
	public static void main(String[] args) {
		ThreadEx targetA = new ThreadEx();
		ThreadEx targetB = new ThreadEx();
		Thread threadA = new Thread(targetA, "A");
		Thread threadB = new Thread(targetB, "B");
		threadA.start();
		threadB.start();
	}
}
