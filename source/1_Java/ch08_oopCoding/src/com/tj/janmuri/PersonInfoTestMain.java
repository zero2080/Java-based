package com.tj.janmuri;
class PersonInfo {
	private String name;
	private int age;
	private char gender; //'m' 'f'
	public PersonInfo() {System.out.println("매개변수 없는 생성자");}
	public PersonInfo(String name, int age, char gender) {
		this.name = name;this.age = age;this.gender = gender;
	}
	public void print() {
		System.out.println("이름:"+name+"/나이:"+age+"/성별:"+(gender=='m'?"남":"여"));
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public char getGender() {return gender;}
	public void setGender(char gender) {this.gender = gender;}
}
public class PersonInfoTestMain{
	public static void main(String[] args) {
		PersonInfo hong = new PersonInfo();
		PersonInfo kang = new PersonInfo("강길동",20,'m');
		kang.print();
	}
}









