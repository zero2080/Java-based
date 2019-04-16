package com.tj.ex1;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminInfo implements EnvironmentAware, InitializingBean{
	private String adminId;
	private String adminPw;
	private String sub_adminId;
	private String sub_adminPw;
	private Environment env;
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("빈 생성하려고 할 때");
		env = environment;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		adminId = env.getProperty("admin.id");
		adminPw = env.getProperty("admin.pw");
		sub_adminId = env.getProperty("sub_admin.id");
		sub_adminPw = env.getProperty("sub_admin.pw");
		System.out.println("빈 막 생성할 때");
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public String getSub_adminId() {
		return sub_adminId;
	}
	public void setSub_adminId(String sub_adminId) {
		this.sub_adminId = sub_adminId;
	}
	public String getSub_adminPw() {
		return sub_adminPw;
	}
	public void setSub_adminPw(String sub_adminPw) {
		this.sub_adminPw = sub_adminPw;
	}
}
