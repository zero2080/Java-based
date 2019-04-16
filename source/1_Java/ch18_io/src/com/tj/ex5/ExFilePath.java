package com.tj.ex5;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ExFilePath {
	public static void main(String[] args) throws IOException {
		File file = new File(".");
		System.out.println("������ : "+file.getAbsolutePath());
		System.out.println("ǥ�ذ�� : "+file.getCanonicalPath());
		System.out.println("������������ millis :"+file.lastModified());
		Date date = new Date(file.lastModified());//������ ������ ������ ��¥
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		System.out.println("������ ������ ���� :"+sdf.format(date));
		System.out.println("�б� �Ӽ� : "+file.canRead());
		System.out.println("���� �Ӽ� : "+file.canWrite());
	}
}
