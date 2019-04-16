package com.tj.ex;

public class MyCalculation {
	private Calculation calculation;
	private int firstNum;
	private int secondNum;
	public void add() {
		calculation.addition(firstNum, secondNum);
	}
	public void sub() {
		calculation.subtraction(firstNum, secondNum);
	}
	public void mul() {
		calculation.multiplication(firstNum, secondNum);
	}
	public void div() {
		calculation.division(firstNum, secondNum);
	}
	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}
	public void setFirstNum(int firstNum) {this.firstNum = firstNum;}
	public void setSecondNum(int secondNum){this.secondNum = secondNum;}
}
