package com.tj.ex6lib;

public interface ILendable {
	public static final byte STATE_BORROWED=1;
	public static final byte STATE_NORMAL = 0;
	public void checkOut(String borrower) throws Exception;
	public void checkIn() throws Exception;
}
