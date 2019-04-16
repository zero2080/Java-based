package com.tj.ex3_student;
// (������) �й�, �̸�, ����, �а�
// (�޼ҵ�) modify(fn, data) //������ 1�� �й�, 2�� �̸�, 3�³���, 4�� �а�
//        infoString()�� print()
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
	public void modify(int fn, String data) {//������ 1�� �й�, 2�� �̸�, 3�³���, 4�� �а�
		switch (fn) {
		case 1: // ��Ʈ���� ���� �ٲٴ� ���("10"�� 10) ���� ��Ʈ������ �ٲٴ� ���(10�� "10")
			hakbun = Integer.parseInt(data); break;
		case 2:
			name = data; break;
		case 3:
			age = Integer.parseInt(data);break;
		case 4:
			major = data; break;
		default:
			System.out.println("�ùٸ��� ���� ��� ��ȣ�� ���� �Ұ��մϴ�");
		}//switch
	}//modify()
	public String infoString() {
		return "[�й�]"+hakbun+"   [�̸�]"+name+"   [����]"+age+"   [�а�]"+major;
	}
	public void print() {
		System.out.println("[�й�]"+hakbun+"   [�̸�]"+name+
											"   [����]"+age+"   [�а�]"+major);
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
















