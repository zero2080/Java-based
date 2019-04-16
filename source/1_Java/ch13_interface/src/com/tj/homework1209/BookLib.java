package com.tj.homework1209;

public class BookLib extends BookInfo implements ILendable {
	private String borrower;
	private String checkOutDate;
	private byte state;
	public BookLib() {}
	public BookLib(String bookNo, String bookTitle, String writer){
		super(bookNo, bookTitle, writer);
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
	}
	@Override
	public void checkIn() {
		if(state!=STATE_BORROWED) {
			System.out.println("대출중이 아닌데 뭥미?");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+getBookTitle()+"\""+"반납완료");
	}
	@Override
	public void checkOut(String borrwer, String checkOutDate) {
		if(state==STATE_BORROWED){
			System.out.println("대출 불가");
			return;
		}
		//대출로직
		this.borrower = borrwer;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; //대출중으로 상태 변환
		System.out.println("\""+getBookTitle()+"\""+"대출완료");
		System.out.println("[대출자]"+borrwer);
		System.out.println("[대출일]"+checkOutDate);
	}
	public void printState() {
		System.out.print(getBookNo()+"\t"+getBookTitle()+"\t");
		System.out.println((state == STATE_NORMAL)?"대출가능":("대출중("+checkOutDate+")"));
	}
}
