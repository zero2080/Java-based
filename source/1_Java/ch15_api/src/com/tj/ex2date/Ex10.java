package com.tj.ex2date;
import java.util.Date;
// 뉴욕, 홍콩, 파리, 서울 현재 시간을 다음과 같은 포맷으로 한꺼번에 출력
// 뉴욕 2018/12/11(화) 오후 05:05
public class Ex10 {
	public static void main(String[] args) {
		Date now = new Date();
		String[] city = {"뉴욕","홍콩","파리","서울"};
		String[] id = {"America/New_York", 
		"Asia/Hong_Kong", "Europe/Paris","Asia/Seoul"};
		Ex10Print printer = new Ex10Print();
		for(int i=0 ; i<id.length ; i++) {
			printer.datePrint(city[i], id[i], now);
		}
	}
}
