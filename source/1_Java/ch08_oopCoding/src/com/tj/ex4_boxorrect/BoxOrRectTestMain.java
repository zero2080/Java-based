package com.tj.ex4_boxorrect;

public class BoxOrRectTestMain {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(2, 6, 9);
		BoxOrRect rect = new BoxOrRect(10, 5);
		box.calVolume();
		rect.calVolume();
		box.print();
		System.out.println(box.infoString());
		rect.print();
		System.out.println(rect.infoString());
	}
}
