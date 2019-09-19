package com.team.pind.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.pind.vo.MemberVO;
import com.team.pind.vo.ProfileVO;

@Repository
public class MemberDAO implements MemberMapper{
	
	@Autowired
	SqlSession sqlsession;
	
	//이메일 난수 업데이트(String 값 'n' 에서 인증용 난수로 변경)
	@Override
	public int updateJoincommit(String pind_mem_Joincommit, String pind_mem_Email) {
		MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
		int result = 0;
		
		result = mapper.updateJoincommit(pind_mem_Joincommit, pind_mem_Email);
		
		return result;
	}

	//회원정보 삽입
	@Override
	public int insertJoin(MemberVO uVO) {
		MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
		int result = 0;
		
		result = mapper.insertJoin(uVO);
		
		return result;
	}

	//이메일 난수 가져오기
	@Override
	public int GetKey(String pind_mem_Email, String pind_mem_Joincommit) {
		MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
		int result = 0;
		
		result = mapper.GetKey(pind_mem_Email, pind_mem_Joincommit);
		
		return result;
	} 
	
	//이메일 중복확인(아이디)
	@Override
	public MemberVO isId(String email) {
			
			MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);		
			MemberVO mem = mapper.isId(email);
			
			return mem;
		}

	//닉네임 중복확인
	@Override
	public MemberVO isNickname(String nickname) {
			
		MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);	
		MemberVO mem = mapper.isNickname(nickname);
			
		return mem;
	}

	@Override
	public MemberVO Memberchk(String pind_mem_Email, String pind_mem_Joincommit) {
		MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
		MemberVO mem = mapper.Memberchk(pind_mem_Email, pind_mem_Joincommit);
		
		return mem;
	}
	
//	//추가 : 프로필 이미지 등록
//		public void insertProfile(ProfileVO pro) {
//			MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
//			
//			mapper.insertProfile(pro);
//		
//		}
		
//		//추가 : 프로필 이미지 가져오기
//		public String getProfile(String logId) {
//			MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
//			
//			String savedfile = mapper.getProfile(logId);
//			
//			return savedfile;
//		}
		
		//가입 시 mCategory 테이블에 사용자 정보 넣어주기  
		public void makeCategory(String pind_mem_Email) {
			MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
			mapper.makeCategory(pind_mem_Email);
			
		}

		
		
}
