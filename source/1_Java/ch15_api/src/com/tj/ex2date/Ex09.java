package com.tj.ex2date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
public class Ex09 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf 
			= new SimpleDateFormat("yy�� MM�� dd�� E���� a hh�� mm��");
		System.out.println("���� : "+sdf.format(date));
		
		sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		System.out.println("���� : "+sdf.format(date));
		
		sdf.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
		System.out.println("�ĸ� : "+sdf.format(date));
	}
}
