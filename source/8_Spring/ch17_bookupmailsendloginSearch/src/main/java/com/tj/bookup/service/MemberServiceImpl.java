package com.tj.bookup.service;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import com.tj.bookup.dao.MemberDao;
import com.tj.bookup.model.Member;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private JavaMailSender mailSender;
	@Override
	public Member getMember(String mid) {
		return memberDao.getMember(mid);
	}
	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}
	@Override
	public int joinMember(final Member member) {
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = 
					"  <h1>"+ member.getMname() +"님의 회원가입을 축하드립니다</h1>"+
					"  <div>" + 
					"    <div>" + 
					"      환영합니다.\n\n" + 
					"      <hr color=\"red\"/>" + 
					"    </div>" + 
					"    <did>" + 
					"      <p style=\"color:blue;\" >파란색 글씨부분</p>" + 
					"      <p style=\"color:red;\">빨간색 글씨부분</p>" + 
					"    </did>" + 
					"  </div>" + 
					"    <div>" + 
					"      <img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20170315064553027.png\" />\n" + 
					"    </div>" + 
					"    <div style=\"font-weight: blod; font-size: 1.2em;\">아무개 사이트 일동</div>\n" + 
					"    <div style=\"color:red;\">서울시 종로구 삼일대로 17길 51 스타골드BD 302호</div>";
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMmail()));
				mimeMessage.setFrom(new InternetAddress("uiux0905@gmail.com"));
				mimeMessage.setSubject(member.getMname()+"님 회원가입감사합니다");
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		mailSender.send(message);
		// 회원가입시 가입한 메일로 축하 메시지 메일을 보낸다
		return memberDao.joinMember(member);
	}
	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		String result = "로그인 성공";
		Member member = memberDao.getMember(mid);
		if(member==null) {
			result = "유효하지 않은 아이디입니다";
		}else if(!member.getMpw().equals(mpw)) {
			result = "비밀번호가 맞지 않습니다";
		}else {
			httpSession.setAttribute("member", member);
			httpSession.setAttribute("mId", member.getMid());
		}
		return result;
	}

	@Override
	public int modifyMember(Member member) {
		System.out.println("서비스 : "+member.toString());
		return memberDao.modifyMember(member);
	}
}
