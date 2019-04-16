package com.tj.ex6hw1218;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainTestOutputStream {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Customer> customers = new ArrayList<Customer>();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(new Date());
		OutputStream os = null;
		try {
			do {
				System.out.print("ȸ�������� �ߴ��Ͻ÷��� N / ��� �Ͻ÷��� press any key : ");
				if(keyboard.readLine().equalsIgnoreCase("n")) break;
				System.out.print("ȸ���̸��� ");
				String name = keyboard.readLine();
				System.out.print("ȸ����ȭ��ȣ�� ");
				String phone = keyboard.readLine();
				System.out.print("������(���� : 08-08)");
				String birth = keyboard.readLine();
				if(birth.equals(todayStr)) {
					System.out.println("�� �� �� �� �� ���� ���ϵ���� �� �� �� �� ��");
				}
				System.out.print("ȸ�� �ּҴ� ");
				String address = keyboard.readLine();
				customers.add(new Customer(name, phone, birth, address));
			}while(true);
		}catch (IOException e) {
			System.out.println("Ű���� �Է� ���� : "+e.getMessage());
		}
		try {
			os = new FileOutputStream("src/com/tj/ex6hw1218/customer.txt");
			for(Customer customer : customers) {
				System.out.println(customer);
				byte[] temp = (customer.toString()+"\r\n").getBytes();
				os.write(temp);
			}
			System.out.println(". . . . . ���� "+customers.size()+"�� ����");
			byte[] temp = (". . . . . ���� "+customers.size()+"�� ����").getBytes();
			os.write(temp);
		} catch (FileNotFoundException e) {
			System.out.println("�ش� ������ ���ٴ� ���� : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IO����"+e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
			}catch (IOException e) {System.out.println(e.getMessage());}
		}
	}
}
