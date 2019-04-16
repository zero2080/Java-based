package com.tj.ex2date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Ex07 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();//12-11(오후 04:42)
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd(a hh:m)");
		System.out.println(sdf.format(cal.getTime()));
		//cal.getTime() : Calendar형인 변수를 date형으로 
	}
}
