package com.team.pind.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.pind.dao.VideoDAO;
import com.team.pind.vo.LikeVO;

@Controller
public class LikeController {

	@Autowired
	VideoDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(LikeController.class);
	
	
	//좋아요 카운트
	@ResponseBody
	@RequestMapping(value = "like-cnt",  method = {RequestMethod.GET, RequestMethod.POST})
		public LikeVO likeCnt (
				String num) {
			
			LikeVO like = dao.likeCnt(num);
			
			return like;
	}
	
	
	//좋아요 카운트 업 
	@ResponseBody
	@RequestMapping(value = "like-up",  method = {RequestMethod.GET, RequestMethod.POST})
		public void likeUp (
				String num, String id) {
						
				int res = dao.likeUp(num);
	}
	
	
	//좋아요 카운트 다운
	@ResponseBody
	@RequestMapping(value = "like-down",  method = {RequestMethod.GET, RequestMethod.POST})
	public void likeDown (
			String num, String id) {
		
		int res = dao.likeDown(num);
	}
	
	//싫어요 카운트 업
	@ResponseBody
	@RequestMapping(value = "dislike-up",  method = {RequestMethod.GET, RequestMethod.POST})
	public void dislikeUp (
			String num, String id) {
		
		int res = dao.dislikeUp(num);
	}
	
	//싫어요 카운트 다운
	@ResponseBody
	@RequestMapping(value = "dislike-down",  method = {RequestMethod.GET, RequestMethod.POST})
	public void dislikeDown (
			String num, String id) {
		
		int res = dao.dislikeDown(num);
	}
	
	
}//end::Class
