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
		return "����:"+width+", ����:"+height+", ����:"+area();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Rectangle) {
			// width ���� obj�� width ���� ����
			boolean w = width == ((Rectangle)obj).width;
			// height���� obj�� height ���� ������ true
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










