package com.tj.method1;
import java.util.ArrayList;
public class Student {
	private String name;
	private int age;
	private ArrayList<String> hobby;
	private double height;
	private double weight;
	public Student(String name, int age, ArrayList<String> hobby) {
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<String> getHobby() {
		return hobby;
	}
	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "이름=" + name + "\n나이=" + age + "\n취미=" + hobby 
				+ "\n키 = " + height + "\n 몸무게 = " + weight;
	}
}












