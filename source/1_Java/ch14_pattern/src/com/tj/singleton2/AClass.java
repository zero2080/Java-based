package com.tj.singleton2;

public class AClass {
	private static AClass SING_INSTANCE= new AClass();
	private int intVar;
	private AClass() { }
	public static AClass getInstance() {
		/*if(SING_INSTANCE==null) {
			SING_INSTANCE = new AClass();
		}*/
		return SING_INSTANCE;
	}
	public int getIntVar() {
        return intVar;
    }
	public void setIntVar(int intVar) {
        this.intVar = intVar; 
    }
}
