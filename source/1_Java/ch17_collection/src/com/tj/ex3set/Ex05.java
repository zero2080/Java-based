package com.tj.ex3set;
import java.util.HashSet;
public class Ex05 {
	public static void main(String[] args) {
		HashSet<Student> hashSet = new HashSet<Student>();
		Student s2 = new Student("�ű浿", 5);
		Student s3 = new Student("�ű浿", 5);
		hashSet.add(s2);
		System.out.println(s2.equals(s3)? "������":"�ٸ���");
		System.out.println(s2.hashCode()==s3.hashCode()? "������":"�ٸ���");
		hashSet.add(s3);
		System.out.println(hashSet+"�ű浿5�� add �Ǿ�����?");
		hashSet.add(new Student("ȫ�浿",6));
		hashSet.add(new Student("ȫ�浿",6));
		System.out.println("���� hashSet��� :"+hashSet);
	}
}
