package com.tj.homework;

public class Point3DTestMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D();
		Point3D p2 = new Point3D(10, 20, 30);
		Point3D p3 = (Point3D)p2.clone();
		if(p2.equals(p3) && p2!=p3) {
			System.out.println("복제성공");
		}
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
}
