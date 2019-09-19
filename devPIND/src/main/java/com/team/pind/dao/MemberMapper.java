package com.team.pind.dao;

import org.apache.ibatis.annotations.Param;

import com.team.pind.vo.MemberVO;
import com.team.pind.vo.ProfileVO;

public interface MemberMapper {
	
	//가입승인 난수 업데이트
	public int updateJoincommit(@Param("pind_mem_Joincommit") String pind_mem_Joincommit, @Param("pind_mem_Email") String pind_mem_Email);
	//회원가입
	public int insertJoin(MemberVO uVO);
	//가입승인 난수 가져오기
	public int GetKey(@Param("pind_mem_Email") String pind_mem_Email, @Param("pind_mem_Joincommit") String pind_mem_Joincommit);
	//이메일 확인(아이디)
	public MemberVO isId(String email);
	//닉네임 중복확인
	public MemberVO isNickname(String nickname);
	
	public MemberVO Memberchk(@Param("pind_mem_Email") String pind_mem_Email, @Param("pind_mem_Joincommit") String pind_mem_Joincommit);
	
//	//프로필 이미지 등록
//	public void insertProfile(ProfileVO pro);
//		
//	//프로필 이미지 가져오기
//	public String getProfile(String logId);
	
	//회원 가입 시 mCategory에 회원 정보 넣기 
	public void makeCategory(String pind_mem_Email);
	
	
		
}
