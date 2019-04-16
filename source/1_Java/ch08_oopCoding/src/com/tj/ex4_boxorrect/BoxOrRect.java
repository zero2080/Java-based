package com.tj.ex4_boxorrect;
public class BoxOrRect {
	private int width;
	private int height;
	private int depth;
	private int volume;
	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	public void calVolume() {
		if(depth==0) {
			volume = width*height;
		}else {
			volume = width*height*depth;
		}
	}
	public void print() {
		if(depth==0) {
			System.out.println(width+"*"+height+" �簢���� ���� :"+volume);
		}else {
			System.out.println(width+"*"+height+"*"+depth+" ������ü�� ���� :"+volume);
		}
	}
	public String infoString() {
		String result = null;
		if(depth==0) {
			result= width+"*"+height+" �簢���� ���� :"+volume;
		}else {
			result = width+"*"+height+"*"+depth+" ������ü�� ���� :"+volume;
		}
		return result;
	}
}
