package com.tj.ex5; ///��
public class ChildClass extends ParentClass {
	public ChildClass() {System.out.println("ChildClass ������");}
	public void method3() {System.out.println("ChildClass�� method3()");}
	@Override // �������̵� : method�� ������
	public void method1() {System.out.println("ChildClass�� method1()");}
	public void method3(int i) { // �����ε� : method�� �ߺ�����
		System.out.println("ChildClass�� �Ű����� �ִ� method3()");
	}
}
