package com.team.pind.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.pind.vo.CommentVO;

@Repository
public class CommentDAO {

	@Autowired
	SqlSession sqls;
	
	public int insert(CommentVO comment) {
		CommentMapper mapper = sqls.getMapper(CommentMapper.class);
		
		int result = mapper.insert(comment);
		
		return result;
	}

	public ArrayList<CommentVO> showList(String num) {
		CommentMapper mapper = sqls.getMapper(CommentMapper.class);
		
		
		ArrayList<CommentVO> cList = new ArrayList<>();
		cList = mapper.showList(num);
		
		return cList;
	}

	public int delete(String num) {
		CommentMapper mapper = sqls.getMapper(CommentMapper.class);
		
		int result = mapper.delete(num);
		
		return result;
	}

	public int update(CommentVO comment) {
		CommentMapper mapper = sqls.getMapper(CommentMapper.class);
		
		int result = mapper.update(comment);
		
		return result;
	}

}
