package com.tj.ex2_man;
public class Man {
	private int age;
	private int height;
	private int weight;
	private String phoneNum; // 01099999999
	public Man() {} // ����Ʈ ������
	public Man(int age) {// new Man(5);
		this.age = age; System.out.println("�Ű����� �ִ� ������ ȣ��");
	}
	public Man(int age, int height, int weight, String phoneNum) {
		this.age = age;	this.height = height; this.weight = weight;
		this.phoneNum = phoneNum;
	}
	public Man(int age, int height, int weight) {
		this.age = age;	this.height = height; this.weight = weight;
	}
	// BMI ���� �����ϴ� calculateBMI() 50 / (1.6*1.6)����
	public double calculateBMI() {
		double bmi = weight/(height*0.01*height*0.01);
		return bmi;
	}
	// bmi������ 30 �ʰ��� �ǰ��� ���̾�Ʈ�� ��õ�ϴ� �޼��� ���/�߻�±����ϴ� �޼��� ���
	public String state() {
		if(calculateBMI()>30) {
			return "�ǰ��� ���̾�Ʈ ��õ�ؿ�";
		}else {
			return "�� ��ó׿�";
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










