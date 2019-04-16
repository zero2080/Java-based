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
			System.out.print("가입을 진행하시겠습니까?(Y/N)");
			join = scanner.next();
			if(join.equalsIgnoreCase("n")) {
				break;
			}else if(join.equalsIgnoreCase("y")) {
				System.out.print("회원이름은?");
				String name = scanner.next();
				System.out.print("전번은?");
				String phone = scanner.next();
				System.out.print("회원주소는?");
				scanner.nextLine();
				String address = scanner.next();
				cs.put(phone, new Customer(name, phone, address));
			}else {
				System.out.println("Y/N 을 선택하세요");
			}//if
		}//while
		Iterator<String> iterator = cs.keySet().iterator();
		if(cs.isEmpty()) {
			System.out.println("가입하신 회원이 없습니다.");
		}else {
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(cs.get(key));
			}
		}
	}//main
}//class











