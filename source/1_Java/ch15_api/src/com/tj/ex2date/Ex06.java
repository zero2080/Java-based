package com.tj.ex2date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
public class Ex06 {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		// "2018�� 12�� 11�� ~"
		SimpleDateFormat sdf = 
			new SimpleDateFormat("yyyy��MM��dd��hh��mm��ss��S");
		// y�� M�� d�� 
		// D(1~365 ������ ���° ������)
		// E����
		// a (����/����)
		// W (���� ���° ������)
		// w (���� ���° ������)
		// H (1~24��) h(1~12��)
		String str = sdf.format(gc.getTime());
		System.out.println(str);
	}
}
