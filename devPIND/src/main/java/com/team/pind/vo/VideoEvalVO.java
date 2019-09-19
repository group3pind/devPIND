package com.team.pind.vo;

public class VideoEvalVO {
	
	String pind_mediaeval_like;
	String pind_mediaeval_dislike;
	String pind_video_Num;
	
	public VideoEvalVO(String pind_mediaeval_like, String pind_mediaeval_dislike, String pind_video_Num) {
		super();
		this.pind_mediaeval_like = pind_mediaeval_like;
		this.pind_mediaeval_dislike = pind_mediaeval_dislike;
		this.pind_video_Num = pind_video_Num;
	}
	
	public VideoEvalVO() {
		super();
	}
	
	public String getPind_mediaeval_like() {
		return pind_mediaeval_like;
	}
	
	public void setPind_mediaeval_like(String pind_mediaeval_like) {
		this.pind_mediaeval_like = pind_mediaeval_like;
	}
	
	public String getPind_mediaeval_dislike() {
		return pind_mediaeval_dislike;
	}
	
	public void setPind_mediaeval_dislike(String pind_mediaeval_dislike) {
		this.pind_mediaeval_dislike = pind_mediaeval_dislike;
	}
	
	public String getPind_video_Num() {
		return pind_video_Num;
	}
	
	public void setPind_video_Num(String pind_video_Num) {
		this.pind_video_Num = pind_video_Num;
	}
	
	@Override
	public String toString() {
		return "VideoEvalVO [pind_mediaeval_like=" + pind_mediaeval_like + ", pind_mediaeval_dislike="
				+ pind_mediaeval_dislike + ", pind_video_Num=" + pind_video_Num + "]";
	}

}
