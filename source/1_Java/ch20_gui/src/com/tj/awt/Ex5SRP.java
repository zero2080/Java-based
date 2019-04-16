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
		btn0 = new Button("����");
		btn1 = new Button("����");
		btn2 = new Button("��");
		list = new List();
		btnExit = new Button("����");
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
		int computer = random.nextInt(3); // 0(����) ,1(����) , 2(��)
		if(e.getSource()==btn0) {//btn0�� ���� ��ư
			switch (computer) {
			case 0:
				list.add("�츮 ����. �ʶ� ���� ����");break;
			case 1:
				list.add("���� �̰��. �� ���� �� ����");break;
			case 2:
				list.add("�ʰ� �̰��. �� ���� �� ��");break;
			}
		}else if(e.getSource()==btn1) {// btn1�� ������ư
			switch (computer) {
			case 0:
				list.add("�ʰ� �̰��. �� ����, �� ����");break;
			case 1:
				list.add("�츮 ����. �ʶ� ���� ����");break;
			case 2:
				list.add("���� �̰��. �� ���� �� ��");break;
			}
		}else if(e.getSource()==btn2) {// btn2�� �� ��ư
			switch (computer) {
			case 0:
				list.add("���� �̰��. �� �� �� ����");break;
			case 1:
				list.add("�ʰ� �̰��. �� �� �� ����");break;
			case 2:
				list.add("�츮 ����. �ʶ� ���� ��");break;
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Ex5SRP("����������");
	}
}