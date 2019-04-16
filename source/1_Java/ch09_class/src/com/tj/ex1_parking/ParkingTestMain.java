package com.tj.ex1_parking;

public class ParkingTestMain {
	public static void main(String[] args) {
		Parking car1 = new Parking("11¶ó1111", 12);
		Parking car2 = new Parking("22·ç2222", 12);
		car1.setOutTime(13);
		car1.outPrint();
		car2.setOutTime(15);
		car2.outPrint();
	}
}
