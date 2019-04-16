package com.tj.awt;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
public class Ex3LoginFrame extends Frame{
	private Panel panel;
	private Label lbl1, lbl2;
	private TextField txtId, txtPw;
	private Button btn;
	public Ex3LoginFrame() {
		panel = new Panel();
		panel.setLayout(new GridLayout(2, 2));
		lbl1 = new Label("아이디");
		txtId = new TextField("ID",20);
		lbl2 = new Label("비밀번호");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btn = new Button("LOGIN");
		panel.add(lbl1); panel.add(txtId);
		panel.add(lbl2); panel.add(txtPw);
		add(panel, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		setVisible(true);
		pack(); // 최소한의 사이즈로 맞춰줌
	}
	public Ex3LoginFrame(String title) {
		this();
		setTitle(title);
	}
	public static void main(String[] args) {
		new Ex3LoginFrame();
	}
}








