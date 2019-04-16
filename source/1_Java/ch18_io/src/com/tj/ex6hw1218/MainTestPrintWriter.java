package com.tj.ex6hw1218;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainTestPrintWriter {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Customer> customers = new ArrayList<Customer>();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(new Date());
		PrintWriter print = null;
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
			print = new PrintWriter("src/com/tj/ex6hw1218/customer.txt");
			for(Customer customer : customers) {
				System.out.println(customer);
				print.println(customer.toString());
			}
			System.out.println(". . . . . ���� "+customers.size()+"�� ����");
			print.println(". . . . . ���� "+customers.size()+"�� ����");
		} catch (FileNotFoundException e) {
			System.out.println("�ش� ������ ���ٴ� ���� : "+e.getMessage());
		} finally {
			if(print!=null) print.close();
		}
	}
}
