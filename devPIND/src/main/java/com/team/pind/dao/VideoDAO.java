package com.team.pind.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.pind.vo.HistoryVO;
import com.team.pind.vo.LikeVO;
import com.team.pind.vo.McategoryVO;
import com.team.pind.vo.VideoVO;

@Repository
public class VideoDAO {

	@Autowired
	SqlSession sqlsession;

	// 비디오 전체 리스트
	public ArrayList<VideoVO> allVideo(){
		VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
		ArrayList<VideoVO> vlist = mapper.allVideo();
		return vlist;
	}
	
	//비디오 삽입
		public int insertVideo(VideoVO vVO) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			int result = mapper.insertVideo(vVO);
			
			return result;
		}
	
	//메인 비디오 리스트
		public ArrayList<VideoVO> getMainList() {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			ArrayList<VideoVO> vlist = mapper.getMainList();
			
			return vlist;
	}
	
	// 비디오 세부사항 업데이트
	public int updateVideo(String pind_video_Title, String pind_video_About, String pind_mCategory, int pind_video_Num) {
		VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
		int result = mapper.updateVideo(pind_video_Title, pind_video_About, pind_mCategory, pind_video_Num);
		
		return result;
	}
	
	// 비디오 넘버 가져오기
	public VideoVO selectVideo(String pind_video_savedfile, String pind_video_date){
		VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
		VideoVO vVO = mapper.selectVideo(pind_video_savedfile, pind_video_date);
		return vVO;
	}
	
	public int insertVideoEval(int pind_video_Num){
		VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
		int result = mapper.insertVideoEval(pind_video_Num);
		return result;
	}
	
	//비디오 페이지 읽기
	public VideoVO getVideoPage(int pind_video_Num) {
		VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
		
		VideoVO video = mapper.getVideoPage(pind_video_Num);
		
		return video;
	}
	

	//hits
	public int hitsUp(int pind_video_Num) {
		VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
		
		int res = mapper.hitsUp(pind_video_Num);
		
		return res;
	}

	//main-search
		public ArrayList<VideoVO> mainSearch(HashMap<String, Object> map) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			ArrayList<VideoVO> vlist = mapper.mainSearch(map);
			
			return vlist;
		}

		
	//좋아요 카운트
		public LikeVO likeCnt(String num) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			LikeVO like = mapper.likeCnt(num);
			
			return like;
		}
		
		//좋아요
		public int likeUp(String num) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			int res = mapper.likeUp(num);
			
			return res;
		}


		public int dislikeUp(String num) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			int res = mapper.dislikeUp(num);
			
			return res;
		}

		public int likeDown(String num) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			int res = mapper.likeDown(num);
			
			return res;
		}

		public int dislikeDown(String num) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			int res = mapper.dislikeDown(num);
			
			return res;
		}

		//myChannel에 내 영상 가져오기 
		public ArrayList<VideoVO> myVideoList(String nick) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			ArrayList<VideoVO> myList = mapper.myVideoList(nick);
			
			return myList;
		}

		
		//추가:카테고리
		public void category(HashMap<String, Object> map) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			int res = mapper.category(map);
			
		}

		//추가:카테고리
		public HashMap<String, Object> getCategoryVideo(String id) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			String cnt = mapper.getCategoryCnt(id);
			McategoryVO mcg = mapper.getCategoryCols(id);
			
			String favCg = "";
			
			if ( mcg.getPind_mcategory_Drama().equals(cnt)) {
				favCg = "drama";
			} else if ( mcg.getPind_mcategory_Movie().equals(cnt)) {
				favCg = "movie";
			} else if ( mcg.getPind_mcategory_Music().equals(cnt)) {
				favCg = "music";
			} else if ( mcg.getPind_mcategory_News().equals(cnt)) {
				favCg = "news";
			} else if ( mcg.getPind_mcategory_Sports().equals(cnt)) {
				favCg = "sports";
			}
			
			ArrayList<VideoVO> clist = mapper.getCategoryVideo(favCg);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("clist", clist);
			map.put("favCg", favCg);
			
			return map;
		}

		
		/*//내 비디오 삭제 (myChannel)
		public int deleteVideo(int num) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			int res = mapper.deleteVideo(num);
			return res;
		}
*/
		//추가2:히스토리
		public int insertHistory(HistoryVO hVo) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			int res = mapper.insertHistory(hVo);
			
			return res;
		}

		//추가2:히스토리
		public ArrayList<HistoryVO> getHistory(String id) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			ArrayList<HistoryVO> hlist = mapper.getHistory(id);
			
			return hlist;
		}

		public void deleteHistory(ArrayList<String> dlist) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			int res = mapper.deleteHistory(dlist);
		}
		
		//up next
		public ArrayList<VideoVO> getOtherVideos(int num) {
			VideoMapper mapper = sqlsession.getMapper(VideoMapper.class);
			
			ArrayList<VideoVO> vlist = mapper.getOtherVideos(num);
			return vlist;
		}

		
}//end::Class
