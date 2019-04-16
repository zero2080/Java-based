package com.tj.ex2date;

import java.util.GregorianCalendar;

public class Ex04 {
	public static void main(String[] args) {
		GregorianCalendar checkOut = new GregorianCalendar(2018,10,26); // 대출일(2018,11,29)
		GregorianCalendar checkIn = new GregorianCalendar();
		long checkOutMilliSec = checkOut.getTimeInMillis();
		long checkInMilliSec = checkIn.getTimeInMillis();
		// 날짜계산(checkOut시점부터 checkIn시점까지의 milliSec)
		long diff = checkInMilliSec - checkOutMilliSec;
		long day = diff / (1000*60*60*24);
		if(day<=14) {
			System.out.println(day+ "일 빌렸네요. 바로 반납해요");
		}else {
			System.out.println((day-14)*100+"원 연체료 받고");
			System.out.println(day+ "일 빌렸네요. 반납해요");
		}
	}
}
