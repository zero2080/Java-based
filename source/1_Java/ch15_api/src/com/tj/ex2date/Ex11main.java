package com.tj.ex2date;

public class Ex11main {
	public static void main(String[] args) {
		Ex11Sawon hong = new Ex11Sawon("a01","ȫ",Part.COMPUTER);
		Ex11Sawon kim = new Ex11Sawon("b01", "��",Part.COMPUTER);
		System.out.println(hong.infoString());
		System.out.println(kim.infoString());
	}
}
