package com.tj.ex3set;
import java.util.HashSet;
import java.util.Iterator;
public class Ex01 {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("str0");
		hashSet.add("str1");
		hashSet.add("str2");
		System.out.println(hashSet);
		hashSet.add("str1");
		System.out.println("�ߺ��� �� ������ Ȯ�� : "+hashSet);
		Iterator<String> iterator = hashSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
