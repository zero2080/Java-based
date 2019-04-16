package com.tj.singleton1;

public class SingletonClass {
	private static SingletonClass SINGLETON_INSTACE;
	private int i;
	private SingletonClass() { }
	public static SingletonClass getSingletonClass() {
		// SingletonClass�� ��ü�� ������ ��ü�����ϰ� �� �ּҸ� ����
		// SingletonClass�� ��ü�� ������ �� ��ü�� �ּҸ� ����
		if(SINGLETON_INSTACE==null) {
			SINGLETON_INSTACE = new SingletonClass();
		}
		return SINGLETON_INSTACE;
	}
	public int getI() {return i;}
	public void setI(int i) {this.i = i;}
}
