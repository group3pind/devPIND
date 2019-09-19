package com.team.pind.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.pind.dao.CommentDAO;
import com.team.pind.vo.CommentVO;


@Controller
public class CommentController {
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	CommentDAO dao;
	
	//코멘트 입력
	@ResponseBody
	@RequestMapping(value = "insertComment",  method = {RequestMethod.GET, RequestMethod.POST})
	public void insert(
			CommentVO comment) {
		
		logger.info(comment.toString());
		int res = dao.insert(comment);
	}
	
	//코멘트 목록 보여주기 
	@ResponseBody
	@RequestMapping(value = "showList", method = RequestMethod.GET
	, produces = "application/json;charset=UTF-8")
	public ArrayList<CommentVO> showList(String num) {
		
		ArrayList<CommentVO> clist = new ArrayList<>();
		clist = dao.showList(num);
		
		return clist;
	}
	
	//코멘트 삭제 
	@ResponseBody
	@RequestMapping(value = "deleteComment", method = RequestMethod.POST)
		public void delete(String num) {
		
		int res = 0;
		res = dao.delete(num);
		
		return;
	}
	
	//코멘트 수정
	@ResponseBody
	@RequestMapping(value = "updateComment", method = RequestMethod.POST)
	public void update(
			CommentVO comment) {
		
		int res = 0;
		res = dao.update(comment);
	
		return;
	}
}
