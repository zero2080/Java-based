package com.tj.ex6super;
public class ChildTestMain {
	public static void main(String[] args) {
		/*ParentClass p = new ParentClass();
		ChildClass  c = new ChildClass();
		p.getMamiName(); p.getPapaName();
		System.out.println("-------------------");
		c.getMamiName(); c.getPapaName();*/
		ChildClass g = new GrandChild();
		g.getMamiName();
		System.out.println(g.getcStr());
		//System.out.println(g.getGc());
	}
}
