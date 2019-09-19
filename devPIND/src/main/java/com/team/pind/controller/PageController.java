package com.team.pind.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.pind.dao.VideoDAO;
import com.team.pind.vo.VideoVO;

@Controller
public class PageController {

	@Autowired
	VideoDAO dao;
	
	/**
	 * 회원 관련 페이지
	 */
	
	// register 폼 불러오기
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGo() {

		return "register";
	}

	// login 페이지 불러오기
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGo() {

		return "login";
	}

	// forgot-password 폼 불러오기
	@RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
	public String forgotPasswordGo() {

		return "forgot-password";
	}

	// account 폼 불러오기
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String accountGo() {

		return "account";
	}
	
	// settings 페이지 불러오기
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String settingsGo() {

		return "settings";
	}


	/**
	 * 영상관련 페이지
	 */
	
	// Channels페이지 불러오기
	@RequestMapping(value = "/channels", method = RequestMethod.GET)
	public String channelsGo() {

		return "channels";
	}

	// Single Channel페이지 불러오기
	@RequestMapping(value = "/mychannel", method = RequestMethod.GET)
	public String singleChannelGo(HttpSession session, Model model) {
		String nick = (String)session.getAttribute("logNickname");
		ArrayList<VideoVO> myList = dao.myVideoList(nick);
		model.addAttribute("myList", myList);
		
		return "single-channel";
	}
	

	// upload-video페이지 불러오기
	@RequestMapping(value = "/upload-video", method = RequestMethod.GET)
	public String uploadVideoGo() {

		return "upload-video";
	}

	// upload페이지 불러오기
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String uploadGo() {

		return "upload-video"; //(*0831수정) 비디오 업로드 연결 페이지 변경
	}

	// subscriptions페이지 불러오기
	@RequestMapping(value = "/subscriptions", method = RequestMethod.GET)
	public String subscriptionsGo() {

		return "subscriptions";
	}

	/**
	 * 기타
	 */
	
	// 404페이지 불러오기
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String notFound() {

		return "404";
	}

	// blank페이지 불러오기
	@RequestMapping(value = "/blank", method = RequestMethod.GET)
	public String blankGo() {

		return "blank";
	}

	// categories페이지 불러오기
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String categoriesGo() {

		return "categories";
	}

	// mostViewed페이지 불러오기
	@RequestMapping(value = "/mostViewed", method = RequestMethod.GET)
	public String mostViewedGo() {
		
		return "mostViewed";
	}

	// mostViewed페이지 불러오기
	@RequestMapping(value = "/myFavorite", method = RequestMethod.GET)
	public String myFavoriteGo() {
		
		return "myFavorite";
	}
}// end::Class
