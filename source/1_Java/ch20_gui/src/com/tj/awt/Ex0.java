package com.tj.awt;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("title");
		Button btn = new Button("버튼");
		frame.add(btn, BorderLayout.NORTH);
		Button btn2 = new Button("버튼2");
		frame.add(btn2, BorderLayout.SOUTH);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setSize(new Dimension(200,300));
		frame.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		frame.setVisible(false); // 안보이게
		frame.dispose(); 		 // frame의 자원을 해제
		System.exit(0);          // 강제 종료
	}
}
