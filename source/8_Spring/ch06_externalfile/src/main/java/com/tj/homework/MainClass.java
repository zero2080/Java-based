package com.tj.homework;
import java.util.Scanner;
import org.springframework.context.support.GenericXmlApplicationContext;
public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String config = null;
		do {
			System.out.print("run OR dev?");
			config = sc.next();
		}while(!config.equals("dev") && !config.equals("run"));
		sc.close();
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("classpath:homework/dev.xml", "classpath:homework/run.xml");
		ctx.refresh();
		EnvInfo envInfo = ctx.getBean("envInfo", EnvInfo.class);
		System.out.println(envInfo);
	}
}
