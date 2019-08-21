package com.team.pind;

import org.springframework.stereotype.Controller;

/**
 * Handles requests for the application home page.
 */
@Controller
public class VideoController {

//	@RequestMapping(value = "/video/{id}", method = RequestMethod.GET)
//	  public void getVideo(HttpServletRequest req, HttpServletResponse res, @PathVariable String id) {
//	    String filePath = FILE_PATH;
//	    
//	    // 데이터 조회
//	    FileModel fileModel = fileService.getFileInfo(Integer.parseInt(id));
//	    
//	    logger.info("동영상 스트리밍 요청 : " + filePath + fileModel.getSaveFileName());
//	    
//	    File getFile = new File(filePath + fileModel.getSaveFileName());
//	    
//	    try {
//	      // 미디어 처리
//	      MultipartFileSender
//	        .fromFile(getFile)
//	        .with(req)
//	        .with(res)
//	        .serveResource();
//	      
//	    } catch (Exception e) {
//	      // 사용자 취소 Exception 은 콘솔 출력 제외
//	      if (!e.getClass().getName().equals("org.apache.catalina.connector.ClientAbortException")) e.printStackTrace();
//	    }
//	  }

}
