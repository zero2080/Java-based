package com.tj.ex1list;
import java.util.ArrayList;
public class Ex02 {
	public static void main(String[] args) {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("str0"); // 0�� �ε���
		arrList.add("str2"); // 1�� �ε���
		arrList.add(1, "str1");//1�� �ε���
		// 1���ε��� add �� ������ 1�� �ε����� 2������
		arrList.add("str3"); // 3�� �ε���
		System.out.println(arrList.get(2));
		arrList.set(2, "str2222222222");
		// toString() ���� ¥�� [str0, str1, str222222, str3]
		System.out.print("[");
		for(int idx=0 ; idx<arrList.size() ; idx++) {
			if(idx!=arrList.size()-1)
				System.out.print(arrList.get(idx)+", ");
			else
				System.out.println(arrList.get(idx)+"]");
		}
		for(String alist : arrList) {
			System.out.println(alist);
		}
		System.out.println(arrList);
	}
}









