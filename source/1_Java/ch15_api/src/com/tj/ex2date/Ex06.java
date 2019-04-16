package com.tj.ex2date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
public class Ex06 {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		// "2018년 12월 11일 ~"
		SimpleDateFormat sdf = 
			new SimpleDateFormat("yyyy년MM월dd일hh시mm분ss초S");
		// y년 M월 d일 
		// D(1~365 올해의 몇번째 날인지)
		// E요일
		// a (오전/오후)
		// W (월의 몇번째 주인지)
		// w (년의 몇번째 주인지)
		// H (1~24시) h(1~12시)
		String str = sdf.format(gc.getTime());
		System.out.println(str);
	}
}
