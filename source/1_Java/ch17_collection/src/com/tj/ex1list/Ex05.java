package com.tj.ex1list;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// ArrayList vs. LinkedList
public class Ex05 {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		System.out.println("arrayList ���� ���������� add�ϴ� �ð�"+addSeqTime(arrayList));
		System.out.println("linkedList ���� ���������� add�ϴ� �ð�"+addSeqTime(linkedList));
		System.out.println("arrayList �߰��ε����� add�ϴ� �ð�"+addRanTime(arrayList));
		System.out.println("linkedList �߰��ε����� add�ϴ� �ð�"+addRanTime(linkedList));
		System.out.println("arrayList ���� ���������� remove�ϴ� �ð�"+revSeqTime(arrayList));
		System.out.println("linkedList ���� ���������� remove�ϴ� �ð�"+revSeqTime(linkedList));
		System.out.println("arrayList �߰��ε����� remove�ϴ� �ð�"+revRanTime(arrayList));
		System.out.println("linkedList �߰��ε����� remove�ϴ� �ð�"+revRanTime(linkedList));
	}
	private static long revRanTime(List<String> list) {
		long st = System.currentTimeMillis();
		for(int i=0 ; i<10000 ; i++)
			list.remove(1);
		long et = System.currentTimeMillis();
		return et-st;
	}
	private static long revSeqTime(List<String> list) {
		long st = System.currentTimeMillis();
		for(int i=list.size()-1 ; i>1000000 ; i--)
			list.remove(i);
		long et = System.currentTimeMillis();
		return et-st;
	}
	private static long addRanTime(List<String> list) {
		long st = System.currentTimeMillis();
		for(int i=0 ; i<1000 ; i++)
			list.add(500, "500�� �ε����� �߰��� �߰�");
		long et = System.currentTimeMillis();
		return et-st;
	}
	private static long addSeqTime(List<String> list) { // ���������� add
		long st = System.currentTimeMillis(); // ���۽����� millis
		for(int i=0 ; i<5000000 ; i++)
			list.add("���� ���������� �������� �߰�");
		long et = System.currentTimeMillis(); // ������ ������ millis
		return et-st;
	}
}













