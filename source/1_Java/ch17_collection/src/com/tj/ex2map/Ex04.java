package com.tj.ex2map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.tj.ex1list.Customer;
public class Ex04 {
	public static void main(String[] args) {
		HashMap<String, Customer> cs = new HashMap<String, Customer>();
		Scanner scanner = new Scanner(System.in);
		String join="";
		while(true) {
			System.out.print("������ �����Ͻðڽ��ϱ�?(Y/N)");
			join = scanner.next();
			if(join.equalsIgnoreCase("n")) {
				break;
			}else if(join.equalsIgnoreCase("y")) {
				System.out.print("ȸ���̸���?");
				String name = scanner.next();
				System.out.print("������?");
				String phone = scanner.next();
				System.out.print("ȸ���ּҴ�?");
				scanner.nextLine();
				String address = scanner.next();
				cs.put(phone, new Customer(name, phone, address));
			}else {
				System.out.println("Y/N �� �����ϼ���");
			}//if
		}//while
		Iterator<String> iterator = cs.keySet().iterator();
		if(cs.isEmpty()) {
			System.out.println("�����Ͻ� ȸ���� �����ϴ�.");
		}else {
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(cs.get(key));
			}
		}
	}//main
}//class











