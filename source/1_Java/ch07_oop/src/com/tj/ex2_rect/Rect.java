package com.tj.ex2_rect;
// �Ӽ�(private) - �޼ҵ�(public, private) - getter & setter �޼ҵ� 
public class Rect {
	private int width;
	private int height;
	public int area() {
		return width*height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {// main���� r1.width(X) r1.getWidth()
		return width;
	}
	public int getHeight() {
		return height;
	}
}
