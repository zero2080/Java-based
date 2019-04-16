package com.tj.ex6lib;
import java.util.Scanner;
public class MainClass {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("java"),
				new BookLib("Oracle DB"),
				new BookLib("jsp"),
				new BookLib("spring"),
				new BookLib("web")};
		/*try {
			books[4].checkOut("ȫ�浿");//webå ȫ�浿�� ��������
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		books[4].setCheckoutDate(new Date(118,10,20)); //18��11��20�Ϸ� ������ ����
		try {
			books[4].checkOut("ȫ����");//������ å �� �����Ϸ��ϸ� �ڿ��ܡڹ߻�
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			books[4].checkIn(); // webå ������ �ݳ��ϱ�
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		// ��������� �׽�Ʈ��
		Scanner scanner = new Scanner(System.in);
		int fn, i=0;
		do{
			System.out.print("[0:��ü ������� ���� / 1:���� / 2:�ݳ�  /�׿�:����] ���ϴ� ��ȣ? ");
			try{
				fn = scanner.nextInt();
			}catch(Exception e){
				System.out.println("���ڸ� �Է��Ͻø� �����ؿ�."); break;
			}
			switch (fn) {
			case 0:
				for(BookLib b : books)
					System.out.println(b);
				break;
			case 1:
				System.out.print("�����ϰ��� �ϴ� å�̸�?");
				scanner.nextLine();
				String bTitle = scanner.nextLine();
				for(i=0 ; i<books.length; i++){
					if(books[i].getBookTitle().equals(bTitle))
						break;
				}
				if(i==books.length){
					System.out.println("�������� ���� å�Դϴ�");
				}else if(books[i].getState()==BookLib.STATE_BORROWED){
					System.out.println("���� ���� å�̶� ���� �Ұ�");
				}else{
					//book[i]�� �����Ѵ�
					System.out.print("������ �̸�?");
					String name = scanner.nextLine();
					try {
						books[i].checkOut(name);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case 2:
				System.out.print("�ݳ��ϰ��� �ϴ� å�̸�?");
				scanner.nextLine();
				bTitle = scanner.nextLine();
				for(i=0 ; i<books.length; i++){
					if(books[i].getBookTitle().equals(bTitle))
						break;
				}
				if(i==books.length){
					System.out.println("�������� ���� å�Դϴ�");
				}else{
					//book[i]�� �ݳ��Ѵ�
					try {
						books[i].checkIn();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			default:
				System.out.println("0, 1, 2 �ܸ� �Է��Ͻø� �����ؿ�.");
			}
		}while(fn>=0 && fn<=2);
		for(BookLib book :books) {
			System.out.println(book);
		}
		scanner.close();
	}//main
}//class
