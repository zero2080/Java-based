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
		int week = gc.get(Calendar.DAY_OF_WEEK);//1:��,2:��,3:ȭ,4:��
		int hour24 = gc.get(Calendar.HOUR_OF_DAY);//15
		int hour12 = gc.get(Calendar.HOUR); // 3
		int minute = gc.get(Calendar.MINUTE);
		int ampm = gc.get(Calendar.AM_PM);//0:����, 1:����
		int second = gc.get(Calendar.SECOND);
		int millisec = gc.get(Calendar.MILLISECOND);
		System.out.print(year+"�� "+(month+1)+"�� "+day+"�� ");
		switch (week) {
			case 1:System.out.print("�Ͽ��� ");break;
			case 2:System.out.print("������ ");break;
			case 3:System.out.print("ȭ���� ");break;
			case 4:System.out.print("������ ");break;
			case 5:System.out.print("����� ");break;
			case 6:System.out.print("�ݿ��� ");break;
			case 7:System.out.print("����� ");break;
		}
		System.out.print(ampm==0? "���� ":"���� ");
		System.out.println(hour12+"��"+minute+"��"+second+"��"+millisec);
		
		System.out.printf("%TY�� %Tm�� %Td�� %Ta���� %TH�� %TM�� %TS��", 
				gc, gc, gc, gc, gc, gc, gc);
	}
}
