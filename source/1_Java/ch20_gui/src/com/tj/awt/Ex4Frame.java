package com.tj.awt;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Ex4Frame extends Frame implements ActionListener{
	private Panel panel;
	private Label label;
	private TextField txtField;
	private Button btnOk, btnExit;
	private List list;
	public Ex4Frame(String title) {
		//setLayout(new BorderLayout());
		panel = new Panel();
		//panel.setLayout(new FlowLayout());
		label = new Label("write");
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("Exit");
		list = new List();
		panel.add(label);
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setSize(new Dimension(400, 200));
		setLocation(200, 100);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOk) {
			if(txtField.getText().trim().equals("")) {
				System.out.println("³¡³½´Ù");
				return;
			}
			list.add(txtField.getText().trim());
			txtField.setText("");
		}else if(e.getSource()==btnExit) {
			setVisible(false);dispose();System.exit(0);
		}
		
	}
}









