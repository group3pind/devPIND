package com.team.pind.dao;

import java.util.ArrayList;

import com.team.pind.vo.CommentVO;

public interface CommentMapper {

	//코멘트 저장
	public int insert(CommentVO comment);

	//코멘트리스트 출력
	public ArrayList<CommentVO> showList(String num);
	
	//코멘트삭제
	public int delete(String num);

	//코멘트 수정
	public int update(CommentVO comment);

}
