package com.tj.ex6atm;
public class ThreadATMTestMain {
	public static void main(String[] args) {
		ATM object = new ATM(20000);
		ThreadATM targetM = new ThreadATM(object);
		ThreadATM targetD = new ThreadATM(object);
		Thread mom = new Thread(targetM, "mom");
		Thread dad = new Thread(targetD, "dad");
		mom.start();
		dad.start();
	}
}