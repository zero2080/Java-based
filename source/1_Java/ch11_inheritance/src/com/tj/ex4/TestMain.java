package com.tj.ex4;
public class TestMain {
	public static void main(String[] args) {
		Parent parent = new Parent();
		System.out.println(parent.p);
		System.out.println("***************************");
		Child1 child1 = new Child1();
		System.out.println(child1.p+"/"+child1.c1/*+"/"+child1.c2*/);
		System.out.println("-----------------------------");
		Child2 child2 = new Child2();
		System.out.println(child2.p+"/"/*+child2.c1*/+"/"+child2.c2);
		System.out.println("++++++++++++++++++++++++++++++");
		GrandChild grandChild = new GrandChild();
		System.out.println(grandChild.p+"/"+grandChild.c1+grandChild.gc);
		// System.out.println(grandChild.c2); »ïÃÌ º¯¼ö´Â ºÒ°¡´É
	}
}