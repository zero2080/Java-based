package com.tj.ex3set;
import java.util.HashSet;
public class Ex05 {
	public static void main(String[] args) {
		HashSet<Student> hashSet = new HashSet<Student>();
		Student s2 = new Student("신길동", 5);
		Student s3 = new Student("신길동", 5);
		hashSet.add(s2);
		System.out.println(s2.equals(s3)? "같은거":"다른거");
		System.out.println(s2.hashCode()==s3.hashCode()? "같은거":"다른거");
		hashSet.add(s3);
		System.out.println(hashSet+"신길동5가 add 되었을까?");
		hashSet.add(new Student("홍길동",6));
		hashSet.add(new Student("홍길동",6));
		System.out.println("최종 hashSet결과 :"+hashSet);
	}
}
