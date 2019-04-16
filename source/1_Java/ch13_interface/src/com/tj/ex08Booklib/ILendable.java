package com.tj.ex08Booklib;

public interface ILendable {
	public static final byte STATE_NORMAL = 0; // 대출가능
	public static final byte STATE_BORROWED = 1; // 대출중
	public void checkOut(String borrower, String checkOutDate);
	public void checkIn();
}