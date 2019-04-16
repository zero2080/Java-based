package com.tj.ex2date;
import java.util.Date;
public class Ex03 {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		int year  = now.getYear()+1900; // now.getYear():1900년부터~
		int month = now.getMonth();
		int day   = now.getDate();
		int hour  = now.getHours();
		int minute= now.getMinutes();
		int second=now.getSeconds();
		System.out.print(year+"년"+(month+1)+"월"+day+"일");
		System.out.println(hour+"시 "+minute+"분"+second+"초");
		System.out.printf("%TY년 %Tm월 %Td일 %Ta요일 %TH시 %TM분 %TS초", 
				now, now, now, now, now, now, now);
	}
}
