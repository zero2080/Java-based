package com.tj.ex;

public class VarEx01 {
	public static void main(String[] args) {
		// JVM이 구동하는 프로그램 시작 부분
		// 데이터타입 변수명 = 초기값
		int age = 23;		// 정수형 변수
		String name = "설현"; // 문자열 변수
		System.out.println("안녕하세요? "+age+"살 "+name+"입니다");
		System.out.println("안녕하세요? "+age+"살 "+name+"입니다");
		System.out.println("안녕하세요? "+age+"살 "+name+"입니다");
		System.out.println("안녕하세요? "+age+"살 "+name+"입니다");
		System.out.println("안녕하세요? "+age+"살 "+name+"입니다");
		age = 47;
		name = "장동건";
		System.out.println("안녕하세요? "+age+"살 "+name+"입니다");
		System.out.println("안녕하세요? "+age+"살 "+name+"입니다");
		// JVM이 구동을 끝내는 프로그램 끝 부분
	}
}