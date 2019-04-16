package com.tj.homework1209;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("a01", "java", "신용권"), new BookLib("a02", "jsp", "아무개"),
				new BookLib("a03", "Oracle", "홍길동"), new BookLib("a04", "mySQL", "이마이"),
				new BookLib("a05", "Servlet", "서블리") };
		Scanner sc = new Scanner(System.in);
		int fn, idx;
		do {
			System.out.print("1:책대출 | 3:책반납 | 0:종료 ?");
			fn = sc.nextInt();
			switch (fn) {
			case 1:// 책대출
				System.out.print("대출하고자 하는 책이름은 ?");
				String bTitle = sc.next();
				// bTitle이 배열에 있는지 검색하여 idx 추출
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break; // 책이름을 찾았으면 for문을 빠져나가
					} // if
				} // for-idx추출
				if (idx == books.length) { // 대출할 책이 배열에 없는 경우
					System.out.println("원하는 도서가 없습니다");
				} else if (idx < books.length) {// 대출할 책이 배열 idx 인덱스에 있는 경우
					// 대출하기
					System.out.print("대출인은 ? ");
					String name = sc.next();
					System.out.print("대출일은 ? ");
					String date = sc.next();
					books[idx].checkOut(name, date);
				} // if
				break;
			case 2:// 책 반납
				System.out.print("반납하고자 하는 책이름?");
				bTitle = sc.next();
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break; // 반납하고자 하는 책이름을 찾으면 for문 나가
					}
				} // for
				if (idx == books.length) {
					System.out.println("왜 여기 가져오셨어요. 우리거 아냐");
				} else if (idx < books.length) {
					books[idx].checkIn(); // 반납
				}
			}
		} while (fn!=0);
		// 배열의 책들의 상태를 출력
		sc.close();
		System.out.println("안녕히 가세요. 오늘 이시간을 기준으로 도서 대출 현황은 아래와 같습니다.");
		for (BookLib b : books) {
			b.printState();
		}
	}
}
