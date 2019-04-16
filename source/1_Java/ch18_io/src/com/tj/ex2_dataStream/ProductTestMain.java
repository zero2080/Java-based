package com.tj.ex2_dataStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ProductTestMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		InputStream      fis = null;
		DataInputStream  dis = null;
		OutputStream     fos = null;
		DataOutputStream dos = null;
		File file = new File("txtFile/productData.dat");
		ArrayList<Product> products = new ArrayList<Product>();
		String name;
		int price, ps;
		//1단계
		try {
			fos = new FileOutputStream(file, true);
			dos = new DataOutputStream(fos);
			do {
				System.out.print("재고입력을 끝내시려면 x, 계속 입력하시려면 press any key");
				if(scanner.next().equalsIgnoreCase("x")) break;
				System.out.print("재고 물품명은 ?");
				dos.writeUTF(scanner.next());
				System.out.print("재고 물품가격은? ");
				dos.writeInt(scanner.nextInt());
				System.out.print("재고 물품 재고량은? ");
				dos.writeInt(scanner.nextInt());
			}while(true);
		}catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음 : "+e.getMessage());
		}catch (IOException e) {
			System.out.println("IO 예외 : "+e.getMessage());
		}finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		scanner.close();
		// 2단계
		try {
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			while(true) {
				name  = dis.readUTF();
				price = dis.readInt();
				ps    = dis.readInt();
				products.add(new Product(name, price, ps));
			}
		}catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음 : "+e.getMessage());
		}catch (IOException e) {
			System.out.println("이상 2단계 끝. ArrayList에 파일 내용 담음");
		}finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		//3단계
		System.out.println("물품명\t가격\t재고갯수");
		for(Product product : products)
			System.out.println(product);
	}
}







