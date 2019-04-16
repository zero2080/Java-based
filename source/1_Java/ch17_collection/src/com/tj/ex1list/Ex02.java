package com.tj.ex1list;
import java.util.ArrayList;
public class Ex02 {
	public static void main(String[] args) {
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("str0"); // 0번 인덱스
		arrList.add("str2"); // 1번 인덱스
		arrList.add(1, "str1");//1번 인덱스
		// 1번인덱스 add 후 기존의 1번 인덱스는 2번으로
		arrList.add("str3"); // 3번 인덱스
		System.out.println(arrList.get(2));
		arrList.set(2, "str2222222222");
		// toString() 따라 짜기 [str0, str1, str222222, str3]
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









