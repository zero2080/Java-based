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
			System.out.println("�������� �ƴѵ� �o��?");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+getBookTitle()+"\""+"�ݳ��Ϸ�");
	}
	@Override
	public void checkOut(String borrwer, String checkOutDate) {
		if(state==STATE_BORROWED){
			System.out.println("���� �Ұ�");
			return;
		}
		//�������
		this.borrower = borrwer;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; //���������� ���� ��ȯ
		System.out.println("\""+getBookTitle()+"\""+"����Ϸ�");
		System.out.println("[������]"+borrwer);
		System.out.println("[������]"+checkOutDate);
	}
	public void printState() {
		System.out.print(getBookNo()+"\t"+getBookTitle()+"\t");
		System.out.println((state == STATE_NORMAL)?"���Ⱑ��":("������("+checkOutDate+")"));
	}
}
