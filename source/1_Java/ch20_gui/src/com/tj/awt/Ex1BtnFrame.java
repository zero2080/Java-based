package com.tj.awt;
/* �̺�Ʈ ó�� ��implements ActionListener -> override
 *          ��������Ʈ��.addActionListener(this)�� �����ڿ� �߰�
 *          ��actionPerformed�� �̺�Ʈ ���� �߰�
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
		btn = new Button("��ư");
		btn2 = new Button("����");
		add(btn, BorderLayout.NORTH);
		add(btn2, BorderLayout.SOUTH);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);
		setSize(new Dimension(200, 300));
		btn2.addActionListener(this); // ��
		addWindowListener(new WindowAdapter() { // x�� ������ ����
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	public Ex1BtnFrame(String title) {
		this(); //�� Ŭ������ ������ �Լ�
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn2) {//���� �̺�Ʈ ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
}








