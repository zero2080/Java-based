package com.tj.ex1_square;
// 패키지 - 클래스명 - 데이터(private, 소문자로 시작) - 생성자 - 메소드 - getter&setter 메소드
public class Square {
	private int side;
	public Square() {// main 에서 Square s = new Square();
		System.out.println("매개변수 없는 생성자 호출");
	}
	public Square(int side) { // main 에서 Square s2 = new Square(5);
		this.side = side;
		System.out.println("매개변수 있는 생성자 호출 "+side+"값 초기화 했어");
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
