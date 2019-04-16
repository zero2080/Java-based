package com.tj.ex2date;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Ex02 {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc);
		int year = gc.get(Calendar.YEAR);
		int month = gc.get(Calendar.MONTH);
		int day = gc.get(Calendar.DATE);
		int week = gc.get(Calendar.DAY_OF_WEEK);//1:일,2:월,3:화,4:수
		int hour24 = gc.get(Calendar.HOUR_OF_DAY);//15
		int hour12 = gc.get(Calendar.HOUR); // 3
		int minute = gc.get(Calendar.MINUTE);
		int ampm = gc.get(Calendar.AM_PM);//0:오전, 1:오후
		int second = gc.get(Calendar.SECOND);
		int millisec = gc.get(Calendar.MILLISECOND);
		System.out.print(year+"년 "+(month+1)+"월 "+day+"일 ");
		switch (week) {
			case 1:System.out.print("일요일 ");break;
			case 2:System.out.print("월요일 ");break;
			case 3:System.out.print("화요일 ");break;
			case 4:System.out.print("수요일 ");break;
			case 5:System.out.print("목요일 ");break;
			case 6:System.out.print("금요일 ");break;
			case 7:System.out.print("토요일 ");break;
		}
		System.out.print(ampm==0? "오전 ":"오후 ");
		System.out.println(hour12+"시"+minute+"분"+second+"초"+millisec);
		
		System.out.printf("%TY년 %Tm월 %Td일 %Ta요일 %TH시 %TM분 %TS초", 
				gc, gc, gc, gc, gc, gc, gc);
	}
}
