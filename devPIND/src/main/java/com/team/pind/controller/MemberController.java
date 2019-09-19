package com.team.pind.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team.pind.dao.MemberDAO;
import com.team.pind.service.FileService2;
import com.team.pind.service.MailSendService;
import com.team.pind.vo.MemberVO;
import com.team.pind.vo.ProfileVO;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberDAO dao;
	@Autowired
	private MailSendService mailsender;
	
	//Join Submit 컨트롤러
	@RequestMapping(value="joinPost", method=RequestMethod.POST)
	public String joinPost(@ModelAttribute("uVO") MemberVO uVO, HttpServletRequest request, Model m) throws Exception {

				int result = dao.insertJoin(uVO);
				dao.makeCategory(uVO.getPind_mem_Email());
				if (result != 1) {
					return "redirect:register";
				}
				
				// 인증 메일 보내기 메서드
				mailsender.mailSendWithUserKey(uVO.getPind_mem_Email(), request);
				m.addAttribute("uVO", uVO);
		return "userRegSuccess";
	}
	
	// e-mail 인증 컨트롤러
	@RequestMapping(value = "joinCommit", method = RequestMethod.GET)
	public String key_alterConfirm(@RequestParam("pind_mem_Email") String pind_mem_Email, @RequestParam("pind_mem_Joincommit") String pind_mem_Joincommit) {

		mailsender.alter_userKey_service(pind_mem_Email, pind_mem_Joincommit); // mailsender의 경우 @Autowired

		return "index";
	}
		
	@ResponseBody
	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	public String checkId (String email) {
			
		logger.info("아이디:{}", email);
		MemberVO member = dao.isId(email);
			
		if ( member == null ) {
			return "useable";
		} else {
			return "nope";
		}
	}
		
	//닉네임 중복 확인 
	@ResponseBody
	@RequestMapping(value = "/checkNickname", method = RequestMethod.POST)
	public String checkNickname (String nickname) {
			
		logger.info("닉네임:{}", nickname);
		MemberVO member = dao.isNickname(nickname);
			
		if ( member == null ) {
			return "useable";
		} else {
			return "nope";
		}
	}
		
	//로그인 처리
	@RequestMapping(value = "login2", method = RequestMethod.POST)
		public String login(
				String email
				, String pass
				, HttpSession session
				, Model model) {
				
			MemberVO mem = dao.isId(email);
				
			if ( mem != null && mem.getPind_mem_PW().equals(pass) ) {
				session.setAttribute("logId", email);
				session.setAttribute("joinCommit", mem.getPind_mem_Joincommit());
				session.setAttribute("logNickname", mem.getPind_mem_Nickname());
					
				return "redirect:/";
			} else {
				model.addAttribute("logMessage", "Wrong Email or Password");
					
				return "login";
			}
					
		}

	//로그아웃
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
			
		session.removeAttribute("logId");
			
		return "redirect:/";
	}
	
	
	//프로필 이미지 관련
			@RequestMapping(value = "profile", method = RequestMethod.POST)
			public String profile(MultipartFile upload, String logId, HttpServletRequest request
					) {
				
				logger.info(upload.getOriginalFilename());
				logger.info(upload.getContentType());
				logger.info("" + upload.getSize());
				logger.info("" + upload.isEmpty());
				
				//첨부파일이 있는 경우 지정된 경로에 저장하고, 원본 파일명과 저장된 파일명을 Board객체에 세팅
				if (!upload.isEmpty()) {
					
					String rootPath = request.getSession().getServletContext().getRealPath("/");
					String uploadPath = rootPath +"resources/profileImage";
					
					String savedfile = FileService2.saveFile(upload, uploadPath, logId);
					
					ProfileVO pro = new ProfileVO();
					
					pro.setPind_mem_Email(logId);
					pro.setPind_image_savedfile(savedfile);
					
//					dao.insertProfile(pro);
				}
				
				return "redirect:/";
			}
			
}//end::Class
