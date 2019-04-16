package com.tj.ex15m;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HomeController {
	@Autowired
	private JavaMailSender mailSender;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "joinView";
	}
	@RequestMapping(value="textMail", method = RequestMethod.GET)
	public String textMail(String name, String mailaddr, Model model){
		System.out.println(name+"님("+mailaddr+")께 메일을 발송하는 로직");
		SimpleMailMessage message = new SimpleMailMessage();
		String text = name+"님 방가 회원가입 축하합니다\n어서오세요\n<h1>거봐!</h1>";
		message.setFrom("hybrid190501@gmail.com"); // 관리자 gmail 계정
		message.setTo(mailaddr); // 받을 메일 
		message.setSubject(name+"님 회원가입감사합니다(setText)");
		message.setText(text);
		mailSender.send(message);
		model.addAttribute("sendResult", "메일 발송 성공");
		return "sendResult";
	}
	@RequestMapping(value="mail", method = RequestMethod.GET)
	public String mail(final String name, final String mailaddr, Model model){
		System.out.println(name+"님("+mailaddr+")께 메일을 발송하는 로직");
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = 
					"  <h1>"+name+"님의 회원가입을 축하드립니다</h1>"+
					"  <div>" + 
					"    <div>" + 
					"      아무개 싸이트에서만 쓰실 수 있는 쿠폰을 드립니다\n\n" + 
					"      <hr color=\"red\"/>" + 
					"    </div>" + 
					"    <did>" + 
					"      <p style=\"color:blue;\" >파란색 감사</p>" + 
					"      <p style=\"color:red;\">빨간색 감사</p>" + 
					"    </did>" + 
					"  </div>" + 
					"    <div>" + 
					"      <img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20170315064553027.png\" />\n" + 
					"    </div>" + 
					"    <div style=\"font-weight: blod; font-size: 1.2em;\">아무개 사이트 일동</div>\n" + 
					"    <div style=\"color:red;\">서울시 종로구 삼일대로 17길 51 스타골드BD 501호</div>";
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, 
						new InternetAddress(mailaddr));
				mimeMessage.setFrom(new InternetAddress("hybrid190501@gmail.com "));
				mimeMessage.setSubject(name+"님 회원가입감사합니다(HTML)");
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		mailSender.send(message);
		model.addAttribute("sendResult", "html로 메일 발송 성공");
		return "sendResult";
	}

}












