package com.tj.ex3_readerWriter;
import java.io.*;
public class Ex03_bufferedReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		BufferedReader keyboard = null;
		try {
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("�о�� ���� �̸��� ��δ� ? (d:mega_IT/inTest.txt)");
			String fileName = keyboard.readLine();
			File file = new File(fileName);
			if(!file.exists()) {
				System.out.println("�������� �ʴ� �����Դϴ�");
				System.exit(1); // ���������� ����
			}
			reader = new FileReader(fileName);  // �⺻ ��Ʈ��
			br     = new BufferedReader(reader);//���� ��Ʈ��
			while(true) {
				String data = br.readLine();
				if(data==null) break; // EOF�� ���
				System.out.println(data);
			}
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(br!=null) br.close();
				if(reader!=null) reader.close();
				if(keyboard!=null) keyboard.close();
			}catch (IOException e) { }
		}
	}
}






