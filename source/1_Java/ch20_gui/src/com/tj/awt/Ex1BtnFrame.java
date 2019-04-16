package com.tj.awt;
/* 이벤트 처리 ①implements ActionListener -> override
 *          ②컴포넌트명.addActionListener(this)을 생성자에 추가
 *          ③actionPerformed에 이벤트 로직 추가
 * */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Ex1BtnFrame extends Frame implements ActionListener{
	private Button btn, btn2;
	public Ex1BtnFrame() {
		btn = new Button("버튼");
		btn2 = new Button("종료");
		add(btn, BorderLayout.NORTH);
		add(btn2, BorderLayout.SOUTH);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);
		setSize(new Dimension(200, 300));
		btn2.addActionListener(this); // ★
		addWindowListener(new WindowAdapter() { // x를 누르면 종료
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	public Ex1BtnFrame(String title) {
		this(); //본 클래스의 생성자 함수
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn2) {//종료 이벤트 로직
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
}








