package com.tj.ex1list;
import java.util.ArrayList;
public class Ex01 {
	public static void main(String[] args) {
		String[] arr = new String[3];
		arr[0] = "str0";
		arr[2] = "str2";
		arr[1] = "str1";
		//arr[3] = "str3";
		System.out.println("arr[2]="+arr[2]);
		arr[2] = "str222222";
		for(int idx=0 ; idx<arr.length ; idx++) {
			System.out.println(idx+":"+arr[idx]);
		}
		for(String a : arr) {
			System.out.println(a);
		}
		//System.out.println(arr);
	}
}














