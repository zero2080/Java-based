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
			books[4].checkOut("홍길동");//web책 홍길동이 빌려보기
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		books[4].setCheckoutDate(new Date(118,10,20)); //18년11월20일로 대출일 조작
		try {
			books[4].checkOut("홍낄똥");//대출한 책 또 대출하려하면 ★예외★발생
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			books[4].checkIn(); // web책 빌린거 반납하기
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		// 여기까지는 테스트용
		Scanner scanner = new Scanner(System.in);
		int fn, i=0;
		do{
			System.out.print("[0:전체 대출상태 열람 / 1:대출 / 2:반납  /그외:종료] 원하는 번호? ");
			try{
				fn = scanner.nextInt();
			}catch(Exception e){
				System.out.println("문자를 입력하시면 종료해요."); break;
			}
			switch (fn) {
			case 0:
				for(BookLib b : books)
					System.out.println(b);
				break;
			case 1:
				System.out.print("대출하고자 하는 책이름?");
				scanner.nextLine();
				String bTitle = scanner.nextLine();
				for(i=0 ; i<books.length; i++){
					if(books[i].getBookTitle().equals(bTitle))
						break;
				}
				if(i==books.length){
					System.out.println("도서관에 없는 책입니다");
				}else if(books[i].getState()==BookLib.STATE_BORROWED){
					System.out.println("대출 중인 책이라 대출 불가");
				}else{
					//book[i]를 대출한다
					System.out.print("대출인 이름?");
					String name = scanner.nextLine();
					try {
						books[i].checkOut(name);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case 2:
				System.out.print("반납하고자 하는 책이름?");
				scanner.nextLine();
				bTitle = scanner.nextLine();
				for(i=0 ; i<books.length; i++){
					if(books[i].getBookTitle().equals(bTitle))
						break;
				}
				if(i==books.length){
					System.out.println("도서관에 없는 책입니다");
				}else{
					//book[i]를 반납한다
					try {
						books[i].checkIn();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			default:
				System.out.println("0, 1, 2 외를 입력하시면 종료해요.");
			}
		}while(fn>=0 && fn<=2);
		for(BookLib book :books) {
			System.out.println(book);
		}
		scanner.close();
	}//main
}//class
