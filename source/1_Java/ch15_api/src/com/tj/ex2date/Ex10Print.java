package com.tj.ex2date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
// 출력용 메소드포함
public class Ex10Print {
	public void datePrint(String city, String id, Date date) {
		SimpleDateFormat sdf =
				new SimpleDateFormat("yyyy/MM/dd(E) a hh:mm");
		sdf.setTimeZone(TimeZone.getTimeZone(id));
		System.out.println(city +" "+sdf.format(date));
	}
}