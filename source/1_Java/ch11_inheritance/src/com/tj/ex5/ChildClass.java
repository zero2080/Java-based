package com.tj.ex5; ///야
public class ChildClass extends ParentClass {
	public ChildClass() {System.out.println("ChildClass 생성자");}
	public void method3() {System.out.println("ChildClass의 method3()");}
	@Override // 오버라이딩 : method의 재정의
	public void method1() {System.out.println("ChildClass의 method1()");}
	public void method3(int i) { // 오버로딩 : method의 중복정의
		System.out.println("ChildClass의 매개변수 있는 method3()");
	}
}
