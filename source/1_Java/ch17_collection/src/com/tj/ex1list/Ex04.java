package com.tj.ex1list;
import java.util.LinkedList;
// LinkedList
public class Ex04 {
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("str0");
		linkedList.add("str1");
		linkedList.add("str2");
		System.out.println(linkedList);
		linkedList.remove(1);
		System.out.println("linkedList�� ������� "+linkedList.size());
		linkedList.clear();
		System.out.println(linkedList.isEmpty()? "�������":"�����ִ�");
	}
}
