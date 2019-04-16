package com.tj.ex1list;
import java.util.ArrayList;
public class Ex03 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		if(list.size()==0) {
			System.out.println("해당 list값이 없습니다");
		}else {
			for(Integer l : list) {
				System.out.println(l);
			}
		}
		System.out.println("list의 갯수는 "+list.size());
		System.out.println("삭제전 "+list);
		list.remove(2);
		System.out.println("삭제후 "+list);
		list.clear(); // size()를 0으로
		if(list.isEmpty()) {
			System.out.println("list안에 값이 없습니다");
		}
		list = null; // ArrayList를 없앰
		/*if(list.isEmpty()) {
			System.out.println("list 안에 값이 없습니다");
		}*/
	}
}









