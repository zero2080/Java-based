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
			throw new Exception("\n"+bookTitle+"�� ���� �������ε�(�ڿ��ܡ�)\n");
		}
		this.borrower = borrower;
		checkoutDate = new Date();
		state = STATE_BORROWED;
		System.out.println("\""+bookTitle+"\"��(��) �ٴ���ٵǾ����ϴ�");
		System.out.println(this);
	}
	@Override
	public void checkIn() throws Exception {
		if(state==STATE_NORMAL){
			throw new Exception("\n"+bookTitle+"�� �������� �ƴѵ�(�ڿ��ܡ�)\n");
		}
		Date now = new Date();
		long diff = now.getTime() - checkoutDate.getTime();
		long day = diff / (24*60*60*1000);
		if(day >14){
			Scanner sc = new Scanner(System.in);
			System.out.println("��ü�� ���� 100�� �ΰ��մϴ�"+(day-14)+"�� ��ü");
			System.out.println("���ž� �� ��ü��� " + ((day-14)*100)+"��");
			System.out.print("��ü�Ḧ ���̳���(Y/N)? ");
			String answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				System.out.println("��ü�Ḧ ���ž� �ݳ�ó���� �˴ϴ�");
				return;
			}else if(!answer.equalsIgnoreCase("y")){
				System.out.println("��ȿ���� ���� ��ư�� �����ż� �ݳ��Ұ�.");
				return;
			}
		}
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle+"\"��(��) �ٹݳ��ٵǾ����ϴ�");
		System.out.println(this);
	}
	@Override
	public String toString() {
		String result = "\""+bookTitle;
		if(state==STATE_BORROWED) {
			result += "\" �� �� �� ("+borrower+" - ";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
			result += sdf.format(checkoutDate);
			result += ")";
		}else {
			result += "\" ���Ⱑ��";
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
