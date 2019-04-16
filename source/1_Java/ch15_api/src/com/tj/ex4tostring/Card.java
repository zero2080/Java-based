package com.tj.ex4tostring;

public class Card {
	private char kind; // �� �� �� ��
	private int  number; // 1:A 10,11,12:KING
	public Card(char kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	@Override
	public String toString() {
		String result = "ī��� "+kind;
		if(number==1) {
			result += " A";
		}else if(number>1 && number<10){
			result += " "+number;
		}else if(number>=10 && number<=12) {
			result += " KING"+number;
		}else {
			result = "��ȿ���� �ʴ� ī���Դϴ�";
		}
		return result;
	}
}
