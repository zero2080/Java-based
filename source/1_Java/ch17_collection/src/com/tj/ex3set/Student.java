package com.tj.ex3set;
public class Student {
	private String name;
	private int grade;
	public Student() { }
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return name+" : "+grade;
	}
	@Override      // s2.equals(s3)
	public boolean equals(Object obj) {
		String thisToString = toString(); // "신길동 : 5"
		String objToString  = obj.toString(); // "신길동 : 5"
		return thisToString.equals(objToString);
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	/*@Override // s2.equals(s3)
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Student) {
			boolean n = name.equals(((Student)obj).name);
			boolean g = grade == ((Student)obj).grade;
			return n && g;
		}		
		return false;
	}*/
}








