package com.team.pind.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team.pind.dao.MemberDAO;
import com.team.pind.dao.VideoDAO;
import com.team.pind.service.FileService2;
import com.team.pind.service.UploadFileUtils;
import com.team.pind.vo.VideoVO;

@Controller
public class VideoController {
	private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

	@Autowired
	MemberDAO mdao;
	
	@Autowired
	VideoDAO dao;
	
	HttpSession session;
	

	@RequestMapping(value = "uploadDetail", method = RequestMethod.POST)
	public String detailUp(MultipartFile upload, HttpServletRequest request, String pind_video_Title, String pind_video_About, String pind_mCategory, String pind_video_savedfile, @RequestParam(value = "pind_video_date", defaultValue = "0")  String pind_video_date) {
		VideoVO vVO = new VideoVO();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Calendar time = Calendar.getInstance();
		pind_video_date = format.format(time.getTime());
		String[] saved = pind_video_savedfile.split("\\.");
		String savedRs = "";
		for(int i = 0; i<saved.length-1; i++){
			if(i == (saved.length-2)){
				savedRs += saved[i];
			}else{
				savedRs += saved[i]+".";
			}
		}
		vVO = dao.selectVideo(savedRs, pind_video_date);
		System.out.println(savedRs);
		System.out.println(pind_video_date);
			if (!upload.isEmpty()) {
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String uploadPath = rootPath +"resources/videoImage";
		FileService2.saveFile2(upload, uploadPath, vVO.getPind_video_Num());
			
	}
		dao.updateVideo(pind_video_Title, pind_video_About, pind_mCategory, vVO.getPind_video_Num());
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "uploadchk", method = RequestMethod.POST, produces="text/plain;charset=utf-8")
	public ResponseEntity<String> uploadchk(MultipartFile fileUpload, Model m, HttpServletRequest request) throws IOException {
		System.out.println(fileUpload.getOriginalFilename());
		System.out.println(fileUpload.getContentType());
		System.out.println(fileUpload.getName());
		System.out.println(fileUpload.getSize());
		
		session = request.getSession();
		
		session = request.getSession();
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		System.out.println(rootPath);
		String uploadPath = rootPath +"/resources/videofile";
		
		ResponseEntity<String> ori = new ResponseEntity<String>(UploadFileUtils.uploadFile(uploadPath, fileUpload.getOriginalFilename(), fileUpload.getBytes(), session, m), HttpStatus.OK);
		
		System.out.println("test"+ori.getBody());
		String savestr[] = ori.getBody().split("/");
		System.out.println(savestr[1]);
		
		return ori;
	}
	
}
