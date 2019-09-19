package com.team.pind.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.pind.dao.MemberDAO;
import com.team.pind.dao.VideoDAO;
import com.team.pind.vo.HistoryVO;
import com.team.pind.vo.VideoVO;

@Controller
public class VideoListController {

	@Autowired
	VideoDAO dao;
	
	@Autowired
	MemberDAO mdao;
	private static final Logger logger = LoggerFactory.getLogger(VideoListController.class);
	
	//video-page페이지 불러오기
		@RequestMapping(value = "/video-page", method = RequestMethod.GET)
		public String videoPageGo(
				@RequestParam(value="num", defaultValue="0") int num
				, Model model
				, HttpSession session
				, String time
				) {
			
			VideoVO video = dao.getVideoPage(num);
			//추가메서드
			ArrayList<VideoVO> olist = dao.getOtherVideos(num);
					
			String id = (String) session.getAttribute("logId");
			if (id != null) {
				HashMap<String, Object> map = new HashMap<>(); 
				map.put("id", id);
				map.put("cg", video.getPind_mCategory());
				dao.category(map);
						
//				String savedfile = mdao.getProfile(id);
//				model.addAttribute("profile", savedfile);
						
				}
					
			model.addAttribute("video", video);
			model.addAttribute("olist", olist);
			
			if(time!=null) {
				model.addAttribute("playtime", time);
			}  else {
				model.addAttribute("playtime", "null");
			}
					
			return "video-page";
		}
		
	//수정 메서드 : search-video페이지 불러오기
			@RequestMapping(value = "/main-search", method = RequestMethod.GET)
			public String searchGo(
					String sort
					, String main_search
					, Model model) {
				
				String kd[] = main_search.split(" ");
				ArrayList<String> kwd = new ArrayList<>();
				
				for(String temp : kd) {
				    temp.trim();
				    kwd.add(temp);
				}
				
				HashMap<String, Object> map = new HashMap<>();
				map.put("sort", sort);
				map.put("kwd", kwd);
				
				ArrayList<VideoVO> vlist = dao.mainSearch(map);
				
				model.addAttribute("vlist", vlist);
				model.addAttribute("main_search", main_search);
				
				return "search-videolist";
			}
			
			
			
			
		//수정 메서드 : hits
		@RequestMapping(value = "/hits-up", method = RequestMethod.GET)
		public String hitsUp(
				@RequestParam(value="num", defaultValue="0") int num,
				String time) {
			
			int res = dao.hitsUp(num);
			
			return "redirect:/video-page?num="+num+"&time="+time;
		}
				
			
		
	/*	// 비디오 삭제
		@RequestMapping(value = "/deleteVideo", method = RequestMethod.GET)
		public String deleteVideo(@RequestParam(value = "num", defaultValue = "0") int num) {
	
			int res = dao.deleteVideo(num);
			if (res == 1) {
				return "redirect:/mychannel";
			}
			System.out.println("failed");
			return "mychannel";
		}
		*/
				
		//추가 : history
		//insert
		@ResponseBody
		@RequestMapping(value = "insertHistory",  method = {RequestMethod.GET, RequestMethod.POST})
		public void insertHistory(
				HistoryVO hVo) {
			
			int res = dao.insertHistory(hVo);
		}
		
		
		// history-page 불러오기
		@RequestMapping(value = "/history-page", method = RequestMethod.GET)
		public String historyPageGo(HttpSession session, Model model) {

			String id = (String) session.getAttribute("logId");
			
			ArrayList<HistoryVO> hlist = dao.getHistory(id);
			model.addAttribute("hlist", hlist);
			
			return "history-page";
		}
		
		//delete
		@RequestMapping(value = "deleteHistory",  method = {RequestMethod.GET, RequestMethod.POST})
		public String deleteHistory(
				String deleHis) {
			
			String del[] = deleHis.split(",");
			ArrayList<String> dlist = new ArrayList<>();
			
			for(String temp : del) {
			    dlist.add(temp);
			}
			
			dao.deleteHistory(dlist);
			
			return "redirect:/history-page";

		}

}//end::Class
