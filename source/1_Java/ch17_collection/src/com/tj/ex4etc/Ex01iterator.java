package com.tj.ex4etc;
import java.util.ArrayList;
import java.util.Iterator;
// ��� collection�� iterator ������ ����
public class Ex01iterator {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("str0");arrayList.add("str1");arrayList.add("str2");
		Iterator<String> iterator = arrayList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		for(String a : arrayList) {
			System.out.println(a);
		}
	}
}
