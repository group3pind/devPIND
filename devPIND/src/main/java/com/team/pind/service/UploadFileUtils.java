package com.team.pind.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;

import com.team.pind.dao.MemberDAO;
import com.team.pind.dao.VideoDAO;
import com.team.pind.vo.MemberVO;
import com.team.pind.vo.VideoVO;

@Service
public class UploadFileUtils {

	static VideoDAO dao;
	static MemberDAO mdao;
	@Autowired 
	private UploadFileUtils(VideoDAO dao, MemberDAO mdao){
		this.dao = dao;
		this.mdao = mdao;
	}
	
	
	static HttpServletRequest request;
	
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData, HttpSession session, Model m) throws IOException{
		//UUID 발급
		UUID uuid = UUID.randomUUID();
		//저장할 파일명 = UUID + 원본이름
//		String savedName = uuid.toString()+"_"+originalName;
		
		//원본 파일의 확장자
		String ext;
		int lastIndex = originalName.lastIndexOf('.');
		//확장자가 없는 경우
		if (lastIndex == -1) {
			ext = "";
		}
		//확장자가 있는 경우
		else {
			ext = "." + originalName.substring(lastIndex + 1);
		}
		
		String origin[] = originalName.split(ext);
		
		//저장할 파일명 (PIND 전용) 세션 아이디+숫자
		String savedName = (String) session.getAttribute("logNickname")+"_"+origin[0];
		
		//저장할 전체 경로를 포함한 File 객체
		File serverFile = null;
				
		//업로드할 디렉토리(날자별 폴더) 생성
		
		//같은 이름의 파일이 있는 경우의 처리
		int cnt = 1;
		while(true){
			serverFile = new File(uploadPath+"/"+savedName+ext);
			if(!serverFile.isFile()) break;
			savedName = (String) session.getAttribute("logNickname")+"_"+origin[0];
			savedName = savedName + (cnt++);
		}
		//파일 경로(기존의 업로드 경로+날짜별 경로), 파일명을 받아 파일 객체 생성
		File target = new File(uploadPath, savedName+ext);
		
		//임시 디렉토리에 업로드된 파일을 지정된 디렉토리로 복사
		FileCopyUtils.copy(fileData, target);
		//썸네일을 생성하기 위한 파일의 확장자 검사
		//파일명이 aaa.bbb.ccc.jpg일 경우 마지막 마침표를 찾기 위해
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = null;
		
		//이미지 파일은 썸네일 사용
		if(MediaUtils.getMediaType(formatName) != null){
			//섬네일 생성
			uploadedFileName = makeThumbnail(uploadPath, savedName);
			//나머지는 아이콘
		}else {
			//아이콘 생성
			uploadedFileName = makeIcon(uploadPath, savedName);
		}
		
			VideoVO vVO = new VideoVO();
			MemberVO mVO = mdao.isId((String)session.getAttribute("logId"));
			vVO.setPind_video_Email((String)session.getAttribute("logId"));
			vVO.setPind_video_orifile(originalName);
			vVO.setPind_video_savedfile(savedName);
			vVO.setPind_video_Nickname(mVO.getPind_mem_Nickname());
			
			if(dao.insertVideo(vVO)==0){
				return "Upload Fail";
			}
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			Calendar time = Calendar.getInstance();
			String pind_video_date = format.format(time.getTime());
			vVO = dao.selectVideo(savedName, pind_video_date);
			dao.insertVideoEval(vVO.getPind_video_Num());
		
		return uploadedFileName+ext;
	}
	
	//날짜별 디렉토리 추출
	private static String calcPath(String uploadPath){
		Calendar cal = Calendar.getInstance();
		//File.separator : 디렉토리 구분자(\\)
		//연도, ex) \\2019
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		System.out.println(yearPath);
		//월, ex) \\2019\\08
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		System.out.println(monthPath);
		//날짜, ex) \\2019\\08\\30
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		System.out.println(datePath);
		//디렉토리 생성 메서드 호출
		makeDir(uploadPath, yearPath, monthPath, datePath);
		return datePath;
	}
	
	//디렉토리 생성
	private static void makeDir(String uploadPath, String... paths){
		// 디렉토리가 존재하면
		if(new File(paths[paths.length-1]).exists()){
			return;
		}
		//디렉토리가 존재하지 않으면
		for(String path : paths){
			//
			File dirPath = new File(uploadPath + path);
			//디렉토리가 존재하지 않으면
			if(!dirPath.exists()){
				dirPath.mkdir();//디렉토리 생성
			}
		}
	}
	
	//썸네일 생성
	private static String makeThumbnail(String uploadPath, String fileName) throws IOException{
		//이미지를 읽기 위한 버퍼
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath, fileName));
		//100픽셀 단위의 썸네일 생성
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		//썸네일의 이름을 생성(원본파일명에 's_'를 붙임)
		String thumbnailName = uploadPath + File.separator + "s_" + fileName;
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		//썸네일 생성
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		//썸네일의 이름을 리턴함
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	//아이콘 생성
	private static String makeIcon(String uploadPath, String fileName){
		//아이콘의 이름
		String iconName = uploadPath + File.separator + fileName;
		//아이콘의 이름을 리턴
		//File.separatorChar : 디렉토리 구분자
		//윈도우 \ , 유닉스(리눅스) /
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

}
