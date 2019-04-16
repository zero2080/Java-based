package com.tj.ex2;

public class Point3DTestMain {
	public static void main(String[] args) {
		Point3D p1 = new Point3D();
		p1.setX(1); p1.setY(2); p1.setZ(3);
		System.out.println(p1.infoString());
		System.out.println("("+p1.getX()+","+p1.getY()+","+p1.getZ()+")");
		Point p2 = new Point();
		p2.setX(2); p2.setY(3);
		System.out.println("p2("+p2.getX()+","+p2.getY()+")");
	}
}
