package com.tj.ex6object_etc;

public class RectangleMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle(5, 6);
		Rectangle r2 = (Rectangle) r1.clone();
		if(r1==r2) {
			System.out.println("�����Ȱ� �ƴϰ� ���� �ų�");
		}else {
			System.out.println("�ٸ� �ּҳ�");
		}
		if(r1.equals(r2)) {
			System.out.println("���� �����̳�");
		}else {
			System.out.println("�ٸ� �����̳�");
		}
		System.out.println("r1 : "+r1);
		System.out.println("r2 : "+r2);
	}
}
