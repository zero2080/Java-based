package com.tj.ex2date;
import java.util.Calendar;
public class Ex01 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		int week = calendar.get(Calendar.DAY_OF_WEEK);//1:��,2:��,3:ȭ,4:��
		int hour24 = calendar.get(Calendar.HOUR_OF_DAY);//15
		int hour12 = calendar.get(Calendar.HOUR); // 3
		int minute = calendar.get(Calendar.MINUTE);
		int ampm = calendar.get(Calendar.AM_PM);//0:����, 1:����
		int second = calendar.get(Calendar.SECOND);
		int millisec = calendar.get(Calendar.MILLISECOND);
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
		calendar, calendar, calendar, calendar, calendar, calendar, calendar);
	}
}
