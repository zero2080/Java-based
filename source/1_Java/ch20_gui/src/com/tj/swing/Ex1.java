package com.tj.swing;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Ex1 extends JFrame implements ActionListener{
	private JLabel jlbl;
	private JButton jbtn;
	private JPanel jpanel;
	public Ex1() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);// x클릭시 종료
		jpanel = (JPanel) getContentPane();
		jpanel.setLayout(new FlowLayout());
		jlbl = new JLabel("즐거운 수요일", (int) CENTER_ALIGNMENT);
		jbtn = new JButton("종료");
		jpanel.add(jlbl);
		jpanel.add(jbtn);
		jlbl.setPreferredSize(new Dimension(250, 200));
		jbtn.setPreferredSize(new Dimension(200, 200));
		setVisible(true);
		pack();
		jbtn.addActionListener(this);
	}
	public Ex1(String title) {
		this();
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
}









