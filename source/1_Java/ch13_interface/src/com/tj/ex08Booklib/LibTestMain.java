package com.tj.ex08Booklib;
import java.util.Scanner;
public class LibTestMain {
	public static void main(String[] args) {
		Book[] books = {new Book("809-01","JAVA","ȫ�浿"),
				new Book("809-02","JSP","ȫ����"),
				new Book("809-03", "Spring","ȫ����")};
		Scanner sc = new Scanner(System.in);
		int fn, idx;
		String no, borrower, checkOutDate;
		do {
			System.out.print("1:����, 2:�ݳ�, 0:����");
			fn = sc.nextInt();
			switch (fn) {
			case 1://����ó��
				System.out.print("�����ϰ��� �ϴ� å�� ��ȣ�� ?");
				no = sc.next();
				// å�� �迭 ���° �濡 �ִ��� ã��
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getNo().equals(no)) {
						break;
					}
				}
				// ã������ �̸��� idx�� 0,1,2 - ��ã������ idx�� 3
				if(idx==books.length) {
					System.out.println("���� ���� ��ȣ�Դϴ�");
				}else {
					//����ó��(�����ΰ� �������� �Է¹޾� checkOut() ȣ��
					System.out.print("�������� ?");
					borrower = sc.next();
					System.out.print("�������� ?");
					checkOutDate = sc.next();
					books[idx].checkOut(borrower, checkOutDate);
				}
				break;
			case 2: //�ݳ�ó��
				System.out.print("�ݳ��ϰ��� �ϴ� å��ȣ�� ?");
				no = sc.next();
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getNo().equals(no)) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("���� ������ȣ�Դϴ�");
				}else {
					books[idx].checkIn();
				}
				break;
			}
		}while(fn!=0);
		System.out.println("�ȳ��� ����ϼ���. ���� ���� �����Դϴ�");
		for(Book book : books) {
			book.print();
		}
	}	
}
