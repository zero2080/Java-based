package com.tj.ex2date;

import java.sql.Date;

public class Ex05 {
	public static void main(String[] args) {
		Date now = new Date(System.currentTimeMillis());
		System.out.println(now);
		System.out.printf("%TY�� %Tm�� %Td�� %Ta���� %TH�� %TM�� %TS��", 
				now, now, now, now, now, now, now);
	}
}
