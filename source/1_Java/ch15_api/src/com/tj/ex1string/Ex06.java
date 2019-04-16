package com.tj.ex1string;

public class Ex06 {
	public static void main(String[] args) {
		StringBuilder strBuilder = new StringBuilder("Hello");
		System.out.println(strBuilder.append(", Java"));
		System.out.println(strBuilder);//Hello, Java
		System.out.println(strBuilder.insert(5, "~~"));
		System.out.println(strBuilder);
		System.out.println(strBuilder.delete(5, 7)); // 5번째부터 7번째 앞까
		System.out.println(strBuilder);
		System.out.println(strBuilder.capacity());
		strBuilder.ensureCapacity(100);
		System.out.println(strBuilder.capacity());
		
	}
}
