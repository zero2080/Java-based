package com.tj.ex2date;
import java.util.Date;
public class Ex03 {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		int year  = now.getYear()+1900; // now.getYear():1900�����~
		int month = now.getMonth();
		int day   = now.getDate();
		int hour  = now.getHours();
		int minute= now.getMinutes();
		int second=now.getSeconds();
		System.out.print(year+"��"+(month+1)+"��"+day+"��");
		System.out.println(hour+"�� "+minute+"��"+second+"��");
		System.out.printf("%TY�� %Tm�� %Td�� %Ta���� %TH�� %TM�� %TS��", 
				now, now, now, now, now, now, now);
	}
}
