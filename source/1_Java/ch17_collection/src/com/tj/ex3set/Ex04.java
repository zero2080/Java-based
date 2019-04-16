package com.tj.ex3set;
import java.util.HashSet;
public class Ex04 {
	public static void main(String[] args) {
		HashSet<Student> hashSet = new HashSet<Student>();
		Student s1 = new Student("홍길동", 6);
		Student s2 = new Student("신길동", 5);
		hashSet.add(s1);
		hashSet.add(s2);
		System.out.println(hashSet);
		hashSet.add(s2);
		System.out.println(hashSet+"중복된 s2는 add 불가");
		hashSet.add(new Student("신길동",5));
		System.out.println(hashSet+"신길동5가 add 되었을까?");
	}
}
