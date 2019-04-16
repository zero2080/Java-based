package com.tj.ex;
// 빈태그, EL를 사용할 경우 : 매개변수없는 생성자, setter, getter
public class PersonInfo {
	private String name;
	private int age;
	private String gender;
	public PersonInfo() {}
	public PersonInfo(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
}
