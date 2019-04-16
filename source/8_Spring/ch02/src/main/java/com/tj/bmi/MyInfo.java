package com.tj.bmi;
import java.util.ArrayList;
public class MyInfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobby;
	private BMIcalculator bmIcalculator;
	public void infoOut() {
		System.out.println("이름 : "+name);
		System.out.println("키   : "+height);
		System.out.println("몸무게:"+weight);
		System.out.println("취미 : "+hobby);
		bmIcalculator.bmiCalculation(weight, height);
	}
	public void setName(String name) {this.name = name;}
	public void setHeight(double height) {this.height = height;}
	public void setWeight(double weight) {this.weight = weight;}
	public void setHobby(ArrayList<String> hobby) {this.hobby = hobby;}
	public void setBmIcalculator(BMIcalculator bmIcalculator) {
		this.bmIcalculator = bmIcalculator;
	}
}