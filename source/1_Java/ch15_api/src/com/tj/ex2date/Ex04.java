package com.tj.ex2date;

import java.util.GregorianCalendar;

public class Ex04 {
	public static void main(String[] args) {
		GregorianCalendar checkOut = new GregorianCalendar(2018,10,26); // ������(2018,11,29)
		GregorianCalendar checkIn = new GregorianCalendar();
		long checkOutMilliSec = checkOut.getTimeInMillis();
		long checkInMilliSec = checkIn.getTimeInMillis();
		// ��¥���(checkOut�������� checkIn���������� milliSec)
		long diff = checkInMilliSec - checkOutMilliSec;
		long day = diff / (1000*60*60*24);
		if(day<=14) {
			System.out.println(day+ "�� ���ȳ׿�. �ٷ� �ݳ��ؿ�");
		}else {
			System.out.println((day-14)*100+"�� ��ü�� �ް�");
			System.out.println(day+ "�� ���ȳ׿�. �ݳ��ؿ�");
		}
	}
}
