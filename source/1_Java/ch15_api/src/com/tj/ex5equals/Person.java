package com.tj.ex5equals;

public class Person {
	private long juminNo; //9202222052123
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public String toString() {
		return "�ֹι�ȣ :"+juminNo;
	}
	@Override     // p1.equals(p2) this�� p1, obj�� p2
	public boolean equals(Object obj) {
		// �� ��ü��juminNo�� obj�� juminNo�� ������ true
		if(obj!=null && obj instanceof Person) {
			return juminNo == ((Person)obj).juminNo;
		}
		return false;
	}
}
