package com.tj.ex2map;
import java.util.ArrayList;
import java.util.HashMap;
public class Ex01 {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("str0"); arrayList.add("str1");
		System.out.println(arrayList);
		System.out.println("1�� �ε��� ��:"+arrayList.get(1));
		arrayList.remove(0);
		arrayList.clear();
		System.out.println("clear ��:"+arrayList);
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(0, "str0");
		hashMap.put(3, "str3");
		hashMap.put(1, "str1");
		System.out.println(hashMap);
		System.out.println("key�� 3�� ������ ��:"+hashMap.get(3));
		System.out.println("key�� 2�� ������ ��(�������):"+hashMap.get(2));
		hashMap.remove(0);
		hashMap.clear();
		System.out.println("clear �� "+hashMap);
		if(hashMap.isEmpty())
			System.out.println("�� ��������");
	}
}
