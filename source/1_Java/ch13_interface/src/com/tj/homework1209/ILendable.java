package com.tj.homework1209;

public interface ILendable {
	public static final byte STATE_BORROWED =1;
	public final static byte STATE_NORMAL = 0;
	public void checkOut(String borrwer, String checkOutDate); // �����ϴ� �޼ҵ�
	public void checkIn();  
	public void printState();
}
