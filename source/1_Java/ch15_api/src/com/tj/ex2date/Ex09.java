package com.tj.ex2date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
public class Ex09 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf 
			= new SimpleDateFormat("yy년 MM월 dd일 E요일 a hh시 mm분");
		System.out.println("서울 : "+sdf.format(date));
		
		sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		System.out.println("뉴욕 : "+sdf.format(date));
		
		sdf.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
		System.out.println("파리 : "+sdf.format(date));
	}
}
