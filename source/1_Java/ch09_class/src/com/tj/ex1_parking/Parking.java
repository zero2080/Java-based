package com.tj.ex1_parking;
public class Parking {
	private String no; //������ȣ (11��1111)
	private int inTime;
	private int outTime;
	private int fee;
	public static final int HOURLYPARKINGRATE = 2100; // final ����
	public Parking() {}
	public Parking(String no, int inTime) {
		this.no = no; this.inTime = inTime;
		System.out.println(no+"�� �������");
		System.out.println("�����ð� : "+inTime+"��");
	}
	public void outPrint() {
		System.out.println("*** "+no+" ***");
		System.out.println("* �����ð� : "+inTime+"��");
		System.out.println("* �����ð� : "+outTime+"��");
		fee = (outTime-inTime)*HOURLYPARKINGRATE;
		System.out.println("* ������� : "+fee+"��");
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
}
