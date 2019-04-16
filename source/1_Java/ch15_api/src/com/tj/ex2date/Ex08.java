package com.tj.ex2date;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Ex08 {
	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		System.out.println(sdf.format(now));
	}
}
