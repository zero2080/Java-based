package com.tj.awt;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
public class Ex5SRP extends Frame implements ActionListener{
	private Panel panel;
	private Button btn0, btn1, btn2, btnExit;
	private List list;
	public Ex5SRP(String title) {
		super(title);
		panel = new Panel();
		btn0 = new Button("가위");
		btn1 = new Button("바위");
		btn2 = new Button("보");
		list = new List();
		btnExit = new Button("종료");
		panel.add(btn0);
		panel.add(btn1);
		panel.add(btn2);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		add(btnExit, BorderLayout.SOUTH);
		setVisible(true);
		setLocation(200, 100);
		setSize(new Dimension(200, 300));
		btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Random random = new Random();
		int computer = random.nextInt(3); // 0(가위) ,1(바위) , 2(보)
		if(e.getSource()==btn0) {//btn0은 가위 버튼
			switch (computer) {
			case 0:
				list.add("우리 비겼다. 너랑 나랑 가위");break;
			case 1:
				list.add("내가 이겼어. 넌 가위 난 바위");break;
			case 2:
				list.add("너가 이겼네. 넌 가위 난 보");break;
			}
		}else if(e.getSource()==btn1) {// btn1은 바위버튼
			switch (computer) {
			case 0:
				list.add("너가 이겼네. 넌 바위, 난 가위");break;
			case 1:
				list.add("우리 비겼다. 너랑 나랑 바위");break;
			case 2:
				list.add("내가 이겼다. 넌 바위 난 보");break;
			}
		}else if(e.getSource()==btn2) {// btn2은 보 버튼
			switch (computer) {
			case 0:
				list.add("내가 이겼다. 넌 보 난 가위");break;
			case 1:
				list.add("너가 이겼어. 넌 보 난 바위");break;
			case 2:
				list.add("우리 비겼다. 너랑 나랑 보");break;
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex5SRP("가위바위보");
	}
}