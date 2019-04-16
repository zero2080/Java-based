package com.tj.ex2map;
import java.util.Hashtable;
import java.util.Iterator;
public class Ex03 {
	public static void main(String[] args) {
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put(100, "È«±æµ¿");
		hashtable.put(101, "±è±æµ¿");
		hashtable.put(102, "½Å±æµ¿");
		System.out.println(hashtable);
		Iterator<Integer> iterator = hashtable.keySet().iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(hashtable.get(key));
		}
	}
}
