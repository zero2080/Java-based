package com.tj.singleton1;

public class SingletonClass {
	private static SingletonClass SINGLETON_INSTACE;
	private int i;
	private SingletonClass() { }
	public static SingletonClass getSingletonClass() {
		// SingletonClass형 객체가 없으면 객체생성하고 그 주소를 리턴
		// SingletonClass형 객체가 있으면 그 객체의 주소를 리턴
		if(SINGLETON_INSTACE==null) {
			SINGLETON_INSTACE = new SingletonClass();
		}
		return SINGLETON_INSTACE;
	}
	public int getI() {return i;}
	public void setI(int i) {this.i = i;}
}
