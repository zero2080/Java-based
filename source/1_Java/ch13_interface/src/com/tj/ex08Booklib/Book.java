package com.tj.ex08Booklib;
public class Book implements ILendable {
	private String no;    // 책 청구번호
	private String title; // 책 제목
	private String writer;// 저자
	private String borrower; // 대출인
	private String checkOutDate;//대출일
	private byte state;  // 대출중 OR 대출가능
	public Book() {
		
	}
	// new Book("001", "JAVA","홍길동")
	public Book(String no, String title, String writer) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		state = STATE_NORMAL;
	}
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state==STATE_BORROWED) {
			System.out.println("대출불가 합니다");
			return;
		}
		// 대출처리(borrower 입력, checkOutDate 입력, state조정, 대출완료 메세지 출력)
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // 본 책이 대출중임을 저장
		// 대출완료 메세지 출력 : "JAVA(홍길동 저)" 도서가 대출완료 되었어요
		System.out.println("\""+title+"("+writer+" 저)\" 도서가 대출완료 되었어요");
	}
	@Override
	public void checkIn() {
		// 반납처리(borrower초기화, checkOutDate초기화, state조정, 반납완료 메세지 출력)
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		// 반납완료 메세지 : "JAVA(홍길동 저)" 도서 반납완료 되었어요
		System.out.println("\""+title+"("+writer+" 저)\" 도서 반납완료 되었어요");
	}
	public void print() {
		// 책번호 JAVA(홍길동 저) : 대출가능 
		// 책번호 JAVA(홍길동 저) : 대출중(2018-10-10)
		String outStr = no + "  "+title+"("+writer+" 저) : ";
		if(state==STATE_NORMAL) {
			outStr += "대출가능";
		}else if(state==STATE_BORROWED) {
			outStr += "대출중("+checkOutDate+")";
		}else {
			outStr += "확인요망 이상해요★★★★★";
		}
		System.out.println(outStr);
	}
	public String getNo() {
		return no;
	}
}













