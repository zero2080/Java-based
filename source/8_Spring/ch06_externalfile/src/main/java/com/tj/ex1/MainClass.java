package com.tj.ex1;
import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
			new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		// propertySources에 외부설정파일의 내용(admin.id,admin.pw,..)을 추가
		try {
			propertySources.addLast(
				new ResourcePropertySource("classpath:admin.properties"));
			propertySources.addLast(
				new ResourcePropertySource("classpath:sub_admin.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("env의 adminId : "+env.getProperty("admin.id"));
		System.out.println("env의 adminPw : "+env.getProperty("admin.pw"));
		System.out.println("env의 sub_adminId : "+env.getProperty("sub_admin.id"));
		System.out.println("env의 sub_adminPw : "+env.getProperty("sub_admin.pw"));
		// xml 파싱해 - adminInfo bean 생성
		ctx.load("classpath:applicationCTX1.xml");
		ctx.refresh();
		AdminInfo info = ctx.getBean("adminInfo", AdminInfo.class);
		System.out.println("info 객체 값");
		System.out.println("adminId : "+info.getAdminId());
		System.out.println("adminPw : "+info.getAdminPw());
		System.out.println("sub_adminId:"+info.getSub_adminId());
		System.out.println("sub_adminPw:"+info.getSub_adminPw());
		ctx.close();
	}
}












