package com.tj.ex6car;
//Car : color, tire, displacement, handle, getSpec()
// main에서 LowGradeCar c1 = new LowGradeCar("레드", "일반타이어", 2000, "파워핸들);
public abstract class Car {
	private String color;
	private String tire;
	private int displacement;
	private String handle;
	public Car() {}
	public Car(String color, String tire, int displacement, String handle) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	public abstract void getSpec();
	public String getColor() {return color;}
	public String getTire() {return tire;}
	public int getDisplacement() {return displacement;}
	public String getHandle() {return handle;}
}
