package com.tj.ex5;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ExFilePath {
	public static void main(String[] args) throws IOException {
		File file = new File(".");
		System.out.println("절대경로 : "+file.getAbsolutePath());
		System.out.println("표준경로 : "+file.getCanonicalPath());
		System.out.println("마지막수정한 millis :"+file.lastModified());
		Date date = new Date(file.lastModified());//마지막 수정한 시점의 날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		System.out.println("마지막 수정한 시점 :"+sdf.format(date));
		System.out.println("읽기 속성 : "+file.canRead());
		System.out.println("쓰기 속성 : "+file.canWrite());
	}
}
