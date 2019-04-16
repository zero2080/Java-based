package com.tj.ex;
public class VarEx02 {
	public static void main(String[] args) {
		int i = 10; // i라는 변수에 10을 할당한다
		byte j = 20;
		int h = 0;
		char c1 = '에';
		char c2 = '이';
		char c3 = '★';
		// 출력 방법 println, print, printf
		// "\t" 탭   "\n"개행
		System.out.println(i+"\t"+j+"\t"+h); // 개행포함
		System.out.print(c1+"\t"+c2+"\t"+c3+"\n");
		System.out.printf("c1코드=%d, c2코드=%d",(int)c1, (int)c2);
		// %d정수출력 / %c문자출력/ %s문자열출력 / %f실수출력 / %x16진수출력
		
	}
}
