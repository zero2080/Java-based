package com.tj.ex6object_etc;

public class Rectangle implements Cloneable{
	private int width;
	private int height;
	public Rectangle(int width, int height) {
		this.width = width; this.height = height;
	}
	private int area() {
		return width*height;
	}
	@Override
	public String toString() {
		return "가로:"+width+", 세로:"+height+", 넓이:"+area();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Rectangle) {
			// width 값과 obj의 width 값이 같고
			boolean w = width == ((Rectangle)obj).width;
			// height값과 obj의 height 값이 같으면 true
			boolean h = height == ((Rectangle)obj).height;
			return w && h;
		}else {
			return false;
		}
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}










