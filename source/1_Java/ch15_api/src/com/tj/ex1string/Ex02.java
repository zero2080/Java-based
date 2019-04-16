package com.tj.ex1string;
import java.util.Scanner;
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fn;
		do {
			System.out.print("I:input, U:update, X:exit");
			fn = sc.next();
			if(fn.equalsIgnoreCase("x")) {
				break;
			}
			/*if(fn.equals("X") || fn.equals("x")) {
				break;
			}*/
		}while(true);
	}
}
