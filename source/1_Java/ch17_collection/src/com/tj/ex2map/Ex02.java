package com.tj.ex2map;
import java.util.HashMap;
import java.util.Iterator;
public class Ex02 {
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("010", "Hong gildong");
		hashMap.put("02", "Kim dongil");
		hashMap.put("016", "Lee SoonSin");
		hashMap.put("031","Yu Ain");
		System.out.println("key가 031인 데이터"+hashMap.get("031"));
		System.out.println(hashMap);
		Iterator<String> iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(hashMap.get(key));
		}
	}
}
