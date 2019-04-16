package com.tj.ex08Booklib;
public class Book implements ILendable {
	private String no;    // å û����ȣ
	private String title; // å ����
	private String writer;// ����
	private String borrower; // ������
	private String checkOutDate;//������
	private byte state;  // ������ OR ���Ⱑ��
	public Book() {
		
	}
	// new Book("001", "JAVA","ȫ�浿")
	public Book(String no, String title, String writer) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		state = STATE_NORMAL;
	}
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state==STATE_BORROWED) {
			System.out.println("����Ұ� �մϴ�");
			return;
		}
		// ����ó��(borrower �Է�, checkOutDate �Է�, state����, ����Ϸ� �޼��� ���)
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // �� å�� ���������� ����
		// ����Ϸ� �޼��� ��� : "JAVA(ȫ�浿 ��)" ������ ����Ϸ� �Ǿ����
		System.out.println("\""+title+"("+writer+" ��)\" ������ ����Ϸ� �Ǿ����");
	}
	@Override
	public void checkIn() {
		// �ݳ�ó��(borrower�ʱ�ȭ, checkOutDate�ʱ�ȭ, state����, �ݳ��Ϸ� �޼��� ���)
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		// �ݳ��Ϸ� �޼��� : "JAVA(ȫ�浿 ��)" ���� �ݳ��Ϸ� �Ǿ����
		System.out.println("\""+title+"("+writer+" ��)\" ���� �ݳ��Ϸ� �Ǿ����");
	}
	public void print() {
		// å��ȣ JAVA(ȫ�浿 ��) : ���Ⱑ�� 
		// å��ȣ JAVA(ȫ�浿 ��) : ������(2018-10-10)
		String outStr = no + "  "+title+"("+writer+" ��) : ";
		if(state==STATE_NORMAL) {
			outStr += "���Ⱑ��";
		}else if(state==STATE_BORROWED) {
			outStr += "������("+checkOutDate+")";
		}else {
			outStr += "Ȯ�ο�� �̻��ؿ�ڡڡڡڡ�";
		}
		System.out.println(outStr);
	}
	public String getNo() {
		return no;
	}
}













