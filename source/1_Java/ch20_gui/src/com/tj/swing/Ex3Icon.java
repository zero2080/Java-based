package com.tj.swing;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Ex3Icon extends JFrame {
	private Container contenPane;
	private ImageIcon i1, i2, i3;
	private JButton btn1, btn2, btn3;
	public Ex3Icon() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		i1 = new ImageIcon("icon/bell.gif");
		i2 = new ImageIcon("icon/java_logo.gif");
		i3 = new ImageIcon("icon/write.gif");
		btn1 = new JButton("버튼1", i1);
		btn2 = new JButton("버튼2", i2);
		btn3 = new JButton("버튼3", i3);
		contenPane.add(btn1);
		contenPane.add(btn2);
		contenPane.add(btn3);
		setVisible(true);
		pack();
	}
	public static void main(String[] args) {
		new Ex3Icon();
	}
}
