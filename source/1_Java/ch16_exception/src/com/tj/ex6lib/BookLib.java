package com.tj.ex6lib;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class BookLib implements ILendable {
	private String bookTitle;
	private String borrower;
	private Date checkoutDate;
	private byte state;
	public BookLib() {}
	public BookLib(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state==STATE_BORROWED){
			throw new Exception("\n"+bookTitle+"은 현재 대출중인데(★예외★)\n");
		}
		this.borrower = borrower;
		checkoutDate = new Date();
		state = STATE_BORROWED;
		System.out.println("\""+bookTitle+"\"이(가) ☆대출☆되었습니다");
		System.out.println(this);
	}
	@Override
	public void checkIn() throws Exception {
		if(state==STATE_NORMAL){
			throw new Exception("\n"+bookTitle+"은 대출중이 아닌데(★예외★)\n");
		}
		Date now = new Date();
		long diff = now.getTime() - checkoutDate.getTime();
		long day = diff / (24*60*60*1000);
		if(day >14){
			Scanner sc = new Scanner(System.in);
			System.out.println("연체료 일일 100원 부가합니다"+(day-14)+"일 연체");
			System.out.println("내셔야 할 연체료는 " + ((day-14)*100)+"원");
			System.out.print("연체료를 내셨나요(Y/N)? ");
			String answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				System.out.println("연체료를 내셔야 반납처리가 됩니다");
				return;
			}else if(!answer.equalsIgnoreCase("y")){
				System.out.println("유효하지 않은 버튼을 누르셔서 반납불가.");
				return;
			}
		}
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle+"\"이(가) ☆반납☆되었습니다");
		System.out.println(this);
	}
	@Override
	public String toString() {
		String result = "\""+bookTitle;
		if(state==STATE_BORROWED) {
			result += "\" 대 출 중 ("+borrower+" - ";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
			result += sdf.format(checkoutDate);
			result += ")";
		}else {
			result += "\" 대출가능";
		}
		return result;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public byte getState() {
		return state;
	}
}
