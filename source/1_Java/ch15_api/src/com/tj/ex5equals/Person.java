package com.tj.ex5equals;

public class Person {
	private long juminNo; //9202222052123
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public String toString() {
		return "주민번호 :"+juminNo;
	}
	@Override     // p1.equals(p2) this는 p1, obj는 p2
	public boolean equals(Object obj) {
		// 내 객체의juminNo와 obj의 juminNo가 같으면 true
		if(obj!=null && obj instanceof Person) {
			return juminNo == ((Person)obj).juminNo;
		}
		return false;
	}
}
