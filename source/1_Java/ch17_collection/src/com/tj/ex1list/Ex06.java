package com.tj.ex1list;
import java.util.Vector;
public class Ex06 {
	public static void main(String[] args) {
		AClass aObj = new AClass();
		AClass a1Obj = new AClass();
		BClass bObj = new BClass();
		Vector<Object> vec = new Vector<Object>();
		vec.add(aObj);
		vec.add(a1Obj);
		vec.add(bObj);
		vec.add("C");
		System.out.println(vec);
		for(Object v : vec)
			System.out.println(v);
		System.out.println("1¹ø ÀÎµ¦½º °ª = "+vec.get(1).toString());
		System.out.println("1¹ø ÀÎµ¦½º °ª = "+vec.elementAt(1).toString());
	}
}
