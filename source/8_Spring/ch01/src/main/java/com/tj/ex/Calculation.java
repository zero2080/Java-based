package com.tj.ex;
public class Calculation {
	private int firstNum;
	private int secondNum;
	public void add() {
		System.out.println("더하기");
		int result = firstNum + secondNum;
		System.out.println(firstNum + " + " + secondNum + " = " + result);
	}
	public void sub() {
		System.out.println("빼기");
		int result = firstNum - secondNum;
		System.out.println(firstNum + " - " + secondNum + " = " + result);
	}
	public void mul() {
		System.out.println("곱하기");
		int result = firstNum * secondNum;
		System.out.println(firstNum + " * " + secondNum + " = " + result);
	}
	public void div() {
		System.out.println("나누기");
		int result = firstNum / secondNum;
		System.out.println(firstNum + " / " + secondNum + " = " + result);
	}
	public void setFirstNum(int firstNum) {this.firstNum = firstNum;}
	public void setSecondNum(int secondNum) {this.secondNum = secondNum;}
}
