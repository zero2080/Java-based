package com.tj.homework1209;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("a01", "java", "�ſ��"), new BookLib("a02", "jsp", "�ƹ���"),
				new BookLib("a03", "Oracle", "ȫ�浿"), new BookLib("a04", "mySQL", "�̸���"),
				new BookLib("a05", "Servlet", "����") };
		Scanner sc = new Scanner(System.in);
		int fn, idx;
		do {
			System.out.print("1:å���� | 3:å�ݳ� | 0:���� ?");
			fn = sc.nextInt();
			switch (fn) {
			case 1:// å����
				System.out.print("�����ϰ��� �ϴ� å�̸��� ?");
				String bTitle = sc.next();
				// bTitle�� �迭�� �ִ��� �˻��Ͽ� idx ����
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break; // å�̸��� ã������ for���� ��������
					} // if
				} // for-idx����
				if (idx == books.length) { // ������ å�� �迭�� ���� ���
					System.out.println("���ϴ� ������ �����ϴ�");
				} else if (idx < books.length) {// ������ å�� �迭 idx �ε����� �ִ� ���
					// �����ϱ�
					System.out.print("�������� ? ");
					String name = sc.next();
					System.out.print("�������� ? ");
					String date = sc.next();
					books[idx].checkOut(name, date);
				} // if
				break;
			case 2:// å �ݳ�
				System.out.print("�ݳ��ϰ��� �ϴ� å�̸�?");
				bTitle = sc.next();
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break; // �ݳ��ϰ��� �ϴ� å�̸��� ã���� for�� ����
					}
				} // for
				if (idx == books.length) {
					System.out.println("�� ���� �������̾��. �츮�� �Ƴ�");
				} else if (idx < books.length) {
					books[idx].checkIn(); // �ݳ�
				}
			}
		} while (fn!=0);
		// �迭�� å���� ���¸� ���
		sc.close();
		System.out.println("�ȳ��� ������. ���� �̽ð��� �������� ���� ���� ��Ȳ�� �Ʒ��� �����ϴ�.");
		for (BookLib b : books) {
			b.printState();
		}
	}
}
