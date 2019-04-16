package com.tj.ex08Booklib;
import java.util.Scanner;
public class LibTestMain {
	public static void main(String[] args) {
		Book[] books = {new Book("809-01","JAVA","홍길동"),
				new Book("809-02","JSP","홍제이"),
				new Book("809-03", "Spring","홍봄봄")};
		Scanner sc = new Scanner(System.in);
		int fn, idx;
		String no, borrower, checkOutDate;
		do {
			System.out.print("1:대출, 2:반납, 0:종료");
			fn = sc.nextInt();
			switch (fn) {
			case 1://대출처리
				System.out.print("대출하고자 하는 책의 번호는 ?");
				no = sc.next();
				// 책이 배열 몇번째 방에 있는지 찾기
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getNo().equals(no)) {
						break;
					}
				}
				// 찾았으면 이리로 idx가 0,1,2 - 못찾았으면 idx가 3
				if(idx==books.length) {
					System.out.println("없는 도서 번호입니다");
				}else {
					//대출처리(대출인과 대출일을 입력받아 checkOut() 호출
					System.out.print("대출인은 ?");
					borrower = sc.next();
					System.out.print("대출일은 ?");
					checkOutDate = sc.next();
					books[idx].checkOut(borrower, checkOutDate);
				}
				break;
			case 2: //반납처리
				System.out.print("반납하고자 하는 책번호는 ?");
				no = sc.next();
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getNo().equals(no)) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("없는 도서번호입니다");
				}else {
					books[idx].checkIn();
				}
				break;
			}
		}while(fn!=0);
		System.out.println("안녕히 퇴근하세요. 현재 도서 상태입니다");
		for(Book book : books) {
			book.print();
		}
	}	
}
