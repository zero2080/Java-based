package com.tj.ex4tostring;

public class CardMain {
	public static void main(String[] args) {
		Card you = new Card('��', 11);
		System.out.println(you);
		// "ī��� �� KING11"
		Card me = new Card('��',1);
		System.out.println(me);
		// "ī��� �� A"
		Card kim = new Card('��',4);
		System.out.println(kim.toString());
		// "ī��� �� 4"
	}
}