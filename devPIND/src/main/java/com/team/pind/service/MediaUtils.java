package com.team.pind.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MediaUtils {
	private static Map<String, MediaType> mediaMap;
	//자동로딩
	static{
		mediaMap = new HashMap<String, MediaType>();
		mediaMap.put("MP3", MediaType.MULTIPART_FORM_DATA);
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
	}
	
	public static MediaType getMediaType(String type){
		return mediaMap.get(type.toUpperCase());
	}
}
