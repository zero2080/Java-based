package com.tj.ex2date;
import java.util.Date;
// ����, ȫ��, �ĸ�, ���� ���� �ð��� ������ ���� �������� �Ѳ����� ���
// ���� 2018/12/11(ȭ) ���� 05:05
public class Ex10 {
	public static void main(String[] args) {
		Date now = new Date();
		String[] city = {"����","ȫ��","�ĸ�","����"};
		String[] id = {"America/New_York", 
		"Asia/Hong_Kong", "Europe/Paris","Asia/Seoul"};
		Ex10Print printer = new Ex10Print();
		for(int i=0 ; i<id.length ; i++) {
			printer.datePrint(city[i], id[i], now);
		}
	}
}
