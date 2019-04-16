package com.tj.ex2date;

import java.sql.Date;

public class Ex05 {
	public static void main(String[] args) {
		Date now = new Date(System.currentTimeMillis());
		System.out.println(now);
		System.out.printf("%TY년 %Tm월 %Td일 %Ta요일 %TH시 %TM분 %TS초", 
				now, now, now, now, now, now, now);
	}
}
