package com.tj.ex1_parking;
public class Parking {
	private String no; //차량번호 (11루1111)
	private int inTime;
	private int outTime;
	private int fee;
	public static final int HOURLYPARKINGRATE = 2100; // final 변수
	public Parking() {}
	public Parking(String no, int inTime) {
		this.no = no; this.inTime = inTime;
		System.out.println(no+"님 어서오세요");
		System.out.println("입차시간 : "+inTime+"시");
	}
	public void outPrint() {
		System.out.println("*** "+no+" ***");
		System.out.println("* 입차시간 : "+inTime+"시");
		System.out.println("* 출차시간 : "+outTime+"시");
		fee = (outTime-inTime)*HOURLYPARKINGRATE;
		System.out.println("* 주차요금 : "+fee+"원");
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
}
