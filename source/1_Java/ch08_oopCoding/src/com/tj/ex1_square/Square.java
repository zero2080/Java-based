package com.tj.ex1_square;
// ��Ű�� - Ŭ������ - ������(private, �ҹ��ڷ� ����) - ������ - �޼ҵ� - getter&setter �޼ҵ�
public class Square {
	private int side;
	public Square() {// main ���� Square s = new Square();
		System.out.println("�Ű����� ���� ������ ȣ��");
	}
	public Square(int side) { // main ���� Square s2 = new Square(5);
		this.side = side;
		System.out.println("�Ű����� �ִ� ������ ȣ�� "+side+"�� �ʱ�ȭ �߾�");
	}
	public int area() {
		return side*side;
	}
	public void setSide(int side) { //s.side=10(X) s.setSide(10)
		this.side = side;
	}
	public int getSide() {
		return side;
	}
}
