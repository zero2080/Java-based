package com.tj.ex3;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;
public class MainClass {
	public static void main(String[] args) {
		System.out.print("dev 또는 run 선택?");
		Scanner sc = new Scanner(System.in);
		String temp = sc.next();
		String config = null;
		if(temp.equals("run")) {
			config = "run";
		}else {
			config ="dev";
		}
		sc.close();
		GenericXmlApplicationContext ctx =
			new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("classpath:applicationRUN.xml",
					"classpath:applicationDEV.xml");
		ctx.refresh();
		ServerInfo serverInfo = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println(serverInfo);
		ctx.close();
	}
}