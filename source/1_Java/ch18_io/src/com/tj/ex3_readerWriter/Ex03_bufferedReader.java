package com.tj.ex3_readerWriter;
import java.io.*;
public class Ex03_bufferedReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		BufferedReader keyboard = null;
		try {
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("읽어올 파일 이름의 경로는 ? (d:mega_IT/inTest.txt)");
			String fileName = keyboard.readLine();
			File file = new File(fileName);
			if(!file.exists()) {
				System.out.println("존재하지 않는 파일입니다");
				System.exit(1); // 정상적으로 종료
			}
			reader = new FileReader(fileName);  // 기본 스트림
			br     = new BufferedReader(reader);//보조 스트림
			while(true) {
				String data = br.readLine();
				if(data==null) break; // EOF일 경우
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






