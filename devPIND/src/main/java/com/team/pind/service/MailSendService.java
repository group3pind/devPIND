package com.team.pind.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.team.pind.dao.MemberMapper;

@Service
public class MailSendService {
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SqlSessionTemplate sqlSession;
	private MemberMapper mapper;
	
	// 이메일 난수 만드는 메서드
	private String init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;

		do {
			num = ran.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}

		} while (sb.length() < size);
		if (lowerCheck) {
			return sb.toString().toLowerCase();
		}
		return sb.toString();
	}

	// 난수를 이용한 키 생성
	private boolean lowerCheck;
	private int size;

	public String getKey(boolean lowerCheck, int size) {
		this.lowerCheck = lowerCheck;
		this.size = size;
		return init();
	}

	// 회원가입 발송 이메일(인증키 발송)
	public void mailSendWithUserKey(String pind_mem_Email, HttpServletRequest request) throws UnknownHostException {
		
		InetAddress ip;
		
		ip = InetAddress.getLocalHost();
		
		String pind_mem_Joincommit = getKey(false, 20);
		mapper = sqlSession.getMapper(MemberMapper.class);
		mapper.GetKey(pind_mem_Email, pind_mem_Joincommit); 
		MimeMessage mail = mailSender.createMimeMessage();
		String htmlStr = "<h2>안녕하세요 PIND 가입 인증 중입니다.</h2><br><br>" 
				+ "<h3>" + pind_mem_Email + "님</h3>" + "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " 
				+ "<a href='http://"+ip.getHostAddress()+":8888" + request.getContextPath() + "/joinCommit?pind_mem_Joincommit="+pind_mem_Joincommit+"&pind_mem_Email="+ pind_mem_Email +"'>인증하기</a></p>"
				+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
		try {
			mail.setSubject("[본인인증] PIND 인증메일입니다.", "utf-8");
			mail.setText(htmlStr, "utf-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(pind_mem_Email));
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		// 아마존 주소 : http://54.180.117.142/MS/user/key_alter?user_id=
		
	}
	
	// 인증 확인 메서드 (Y 값으로 바꿔주는 메서드)
	public int alter_userKey_service(String pind_mem_Email, String pind_mem_Joincommit) {
		
		int resultCnt = 0;
		
		mapper = sqlSession.getMapper(MemberMapper.class);
		resultCnt = mapper.updateJoincommit(pind_mem_Joincommit, pind_mem_Email);
		
		return resultCnt;
	}
}
