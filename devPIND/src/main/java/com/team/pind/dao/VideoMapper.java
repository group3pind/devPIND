package com.team.pind.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.team.pind.vo.HistoryVO;
import com.team.pind.vo.LikeVO;
import com.team.pind.vo.McategoryVO;
import com.team.pind.vo.VideoVO;

public interface VideoMapper {
	
	public ArrayList<VideoVO> allVideo();
	public int insertVideo(VideoVO vVO);
	public int updateVideo(@Param("pind_video_Title")String pind_video_Title, @Param("pind_video_About")String pind_video_About, @Param("pind_mCategory")String pind_mCategory, @Param("pind_video_Num")int pind_video_Num);
	public VideoVO selectVideo(@Param("pind_video_savedfile")String pind_video_savedfile, @Param("pind_video_date")String pind_video_date);
	public int insertVideoEval(@Param("pind_video_Num")int pind_video_Num);
	
	public VideoVO getVideoPage(int pind_video_Num);
	public int hitsUp(int pind_video_Num);
	
	public ArrayList<VideoVO> mainSearch(HashMap<String, Object> map);
	
	public int likeUp(String num);
	
	public LikeVO likeCnt(String num);
	
	public int dislikeUp(String num);
	
	public int likeDown(String num);
	
	public int dislikeDown(String num);
	
	public ArrayList<VideoVO> myVideoList(String nick);	//내가 업로드한 영상 가져오기 
	
	//추가
	public ArrayList<VideoVO> getMainList();
	
	//추가:카테고리
	public int category(HashMap<String, Object> map);

	//추가:카테고리
	public String getCategoryCnt(String id);

	//추가:카테고리
	public McategoryVO getCategoryCols(String id);

	//추가:카테고리
	public ArrayList<VideoVO> getCategoryVideo(String favCg);
	
	
	/*
	//내 비디오 삭제
	public int deleteVideo(int num);*/
	
	//추가2:히스토리
	public int insertHistory(HistoryVO hVo);

	//추가2:히스토리
	public ArrayList<HistoryVO> getHistory(String id);

	public int deleteHistory(ArrayList<String> dlist);
	
	
	//추가 :다른비디오들
		public ArrayList<VideoVO> getOtherVideos(int num);
}
