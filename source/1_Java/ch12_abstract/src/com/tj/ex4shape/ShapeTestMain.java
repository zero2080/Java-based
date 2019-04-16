package com.tj.ex4shape;
public class ShapeTestMain {
	public static void main(String[] args) {
		Shape c = new Circle(5);
		Shape t = new Triangle(4, 5);
		Shape r = new Rectangle(4, 5);
		Shape[] shape = {c, t, r};
		for(Shape s :shape) {
			s.area();                 //반지름이 5인 원의 넓이는 78.5
			System.out.println(s.getStringArea());	//원의 넓이는 78.5
			System.out.println(s.getKind()+"의 넓이는 "+s.getArea());//원의 넓이는 78.5
			s.draw();
			System.out.println("=============================");
		}//for
	}//main
}//class