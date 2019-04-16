package com.tj.ex1list;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// ArrayList vs. LinkedList
public class Ex05 {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		System.out.println("arrayList 끝에 순차적으로 add하는 시간"+addSeqTime(arrayList));
		System.out.println("linkedList 끝에 순차적으로 add하는 시간"+addSeqTime(linkedList));
		System.out.println("arrayList 중간인덱스에 add하는 시간"+addRanTime(arrayList));
		System.out.println("linkedList 중간인덱스에 add하는 시간"+addRanTime(linkedList));
		System.out.println("arrayList 끝에 순차적으로 remove하는 시간"+revSeqTime(arrayList));
		System.out.println("linkedList 끝에 순차적으로 remove하는 시간"+revSeqTime(linkedList));
		System.out.println("arrayList 중간인덱스에 remove하는 시간"+revRanTime(arrayList));
		System.out.println("linkedList 중간인덱스에 remove하는 시간"+revRanTime(linkedList));
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
			list.add(500, "500번 인덱스에 중간에 추가");
		long et = System.currentTimeMillis();
		return et-st;
	}
	private static long addSeqTime(List<String> list) { // 순차적으로 add
		long st = System.currentTimeMillis(); // 시작시점의 millis
		for(int i=0 ; i<5000000 ; i++)
			list.add("끝에 순차적으로 차곡차곡 추가");
		long et = System.currentTimeMillis(); // 끝나는 시점의 millis
		return et-st;
	}
}













