package com.tj.ex08Booklib;

public interface ILendable {
	public static final byte STATE_NORMAL = 0; // ���Ⱑ��
	public static final byte STATE_BORROWED = 1; // ������
	public void checkOut(String borrower, String checkOutDate);
	public void checkIn();
}