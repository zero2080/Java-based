package com.tj.ex3set;
import java.util.HashSet;
public class Ex04 {
	public static void main(String[] args) {
		HashSet<Student> hashSet = new HashSet<Student>();
		Student s1 = new Student("ȫ�浿", 6);
		Student s2 = new Student("�ű浿", 5);
		hashSet.add(s1);
		hashSet.add(s2);
		System.out.println(hashSet);
		hashSet.add(s2);
		System.out.println(hashSet+"�ߺ��� s2�� add �Ұ�");
		hashSet.add(new Student("�ű浿",5));
		System.out.println(hashSet+"�ű浿5�� add �Ǿ�����?");
	}
}
