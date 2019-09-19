package com.team.pind.controller;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.team.pind.dao.MemberDAO;
import com.team.pind.dao.VideoDAO;
import com.team.pind.vo.VideoVO;

@Controller
public class HomeController {

	@Autowired
	VideoDAO dao;

	@Autowired
	MemberDAO mdao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	//메인화면(index) 불러오기1
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String index(Model model, HttpSession session, SessionStatus status) {
			
			
			ArrayList<VideoVO> vlist = dao.getMainList();
			
			String id = (String) session.getAttribute("logId");
			
			if ( id != null ) {
				HashMap<String, Object> map = dao.getCategoryVideo(id);
			
				model.addAttribute("clist", map.get("clist"));
				model.addAttribute("favCg", map.get("favCg"));
				
//				String savedfile = mdao.getProfile(id);
//				model.addAttribute("profile", savedfile);
			}

			Collections.shuffle(vlist);
			
			model.addAttribute("vlist", vlist);
			
			return "index";
		}
		
	//메인화면(index) 불러오기2
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexGo() {
			
		return "redirect:/";
	}

	//비디오 목록 보여주기
		public ArrayList<VideoVO> videoInit() {
			ArrayList<VideoVO> vlist = new ArrayList();
			vlist = dao.allVideo();
			Collections.shuffle(vlist);
			return vlist;
		}

}
