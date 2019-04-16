package com.tj.ex2_man;
public class Man {
	private int age;
	private int height;
	private int weight;
	private String phoneNum; // 01099999999
	public Man() {} // 디폴트 생성자
	public Man(int age) {// new Man(5);
		this.age = age; System.out.println("매개변수 있는 생성자 호출");
	}
	public Man(int age, int height, int weight, String phoneNum) {
		this.age = age;	this.height = height; this.weight = weight;
		this.phoneNum = phoneNum;
	}
	public Man(int age, int height, int weight) {
		this.age = age;	this.height = height; this.weight = weight;
	}
	// BMI 지수 리턴하는 calculateBMI() 50 / (1.6*1.6)리턴
	public double calculateBMI() {
		double bmi = weight/(height*0.01*height*0.01);
		return bmi;
	}
	// bmi지수가 30 초과시 건강한 다이어트를 추천하는 메세지 출력/잘사는구만하는 메세지 출력
	public String state() {
		if(calculateBMI()>30) {
			return "건강한 다이어트 추천해요";
		}else {
			return "잘 사시네요";
		}
	}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}
	public int getWeight() {return weight;}
	public void setWeight(int weight) {this.weight = weight;}
	public String getPhoneNum() {return phoneNum;}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
}










