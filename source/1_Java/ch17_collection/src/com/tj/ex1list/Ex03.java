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
			System.out.println("�ش� list���� �����ϴ�");
		}else {
			for(Integer l : list) {
				System.out.println(l);
			}
		}
		System.out.println("list�� ������ "+list.size());
		System.out.println("������ "+list);
		list.remove(2);
		System.out.println("������ "+list);
		list.clear(); // size()�� 0����
		if(list.isEmpty()) {
			System.out.println("list�ȿ� ���� �����ϴ�");
		}
		list = null; // ArrayList�� ����
		/*if(list.isEmpty()) {
			System.out.println("list �ȿ� ���� �����ϴ�");
		}*/
	}
}









