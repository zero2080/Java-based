package com.tj.ex3_student;
// (데이터) 학번, 이름, 나이, 학과
// (메소드) modify(fn, data) //변경기능 1은 학번, 2는 이름, 3는나이, 4는 학과
//        infoString()과 print()
public class Student {
	private int hakbun;
	private String name;
	private int age;
	private String major;
	public Student(int hakbun, String name, int age, String major) {
		this.hakbun = hakbun;
		this.name = name;
		this.age = age;
		this.major = major;
	}
	public void modify(int fn, String data) {//변경기능 1은 학번, 2는 이름, 3는나이, 4는 학과
		switch (fn) {
		case 1: // 스트링을 수로 바꾸는 경우("10"을 10) 수를 스트링으로 바꾸는 경우(10을 "10")
			hakbun = Integer.parseInt(data); break;
		case 2:
			name = data; break;
		case 3:
			age = Integer.parseInt(data);break;
		case 4:
			major = data; break;
		default:
			System.out.println("올바르지 않은 기능 번호라 수정 불가합니다");
		}//switch
	}//modify()
	public String infoString() {
		return "[학번]"+hakbun+"   [이름]"+name+"   [나이]"+age+"   [학과]"+major;
	}
	public void print() {
		System.out.println("[학번]"+hakbun+"   [이름]"+name+
											"   [나이]"+age+"   [학과]"+major);
	}//print()
	public int getHakbun() {return hakbun;}
	public void setHakbun(int hakbun) {this.hakbun = hakbun;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public String getMajor() {return major;}
	public void setMajor(String major) {this.major = major;}
}//class
















