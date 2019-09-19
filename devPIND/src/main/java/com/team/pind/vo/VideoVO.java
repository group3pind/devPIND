package com.team.pind.vo;

public class VideoVO {
	int pind_video_Num;
	String pind_video_Title;	//default 'notitled'
	String pind_video_Date;		//default sysdate
	int pind_video_Hits;		//default 0
	String pind_video_About;
	String pind_video_orifile;	//not null
	String pind_video_savedfile;	//not null
	String pind_video_Email;	//not null
	String pind_mCategory;
	String pind_video_Nickname;
	
	public VideoVO() {
		super();
	}

	public VideoVO(int pind_video_Num, String pind_video_Title, String pind_video_Date, int pind_video_Hits,
			String pind_video_About, String pind_video_orifile, String pind_video_savedfile, String pind_video_Email,
			String pind_mCategory, String pind_video_Nickname) {
		super();
		this.pind_video_Num = pind_video_Num;
		this.pind_video_Title = pind_video_Title;
		this.pind_video_Date = pind_video_Date;
		this.pind_video_Hits = pind_video_Hits;
		this.pind_video_About = pind_video_About;
		this.pind_video_orifile = pind_video_orifile;
		this.pind_video_savedfile = pind_video_savedfile;
		this.pind_video_Email = pind_video_Email;
		this.pind_mCategory = pind_mCategory;
		this.pind_video_Nickname = pind_video_Nickname;
	}


	public int getPind_video_Num() {
		return pind_video_Num;
	}

	public void setPind_video_Num(int pind_video_Num) {
		this.pind_video_Num = pind_video_Num;
	}

	public String getPind_video_Title() {
		return pind_video_Title;
	}

	public void setPind_video_Title(String pind_video_Title) {
		this.pind_video_Title = pind_video_Title;
	}

	public String getPind_video_Date() {
		return pind_video_Date;
	}

	public void setPind_video_Date(String pind_video_Date) {
		this.pind_video_Date = pind_video_Date;
	}

	public int getPind_video_Hits() {
		return pind_video_Hits;
	}

	public void setPind_video_Hits(int pind_video_Hits) {
		this.pind_video_Hits = pind_video_Hits;
	}

	
	public String getPind_video_Email() {
		return pind_video_Email;
	}


	public void setPind_video_Email(String pind_video_Email) {
		this.pind_video_Email = pind_video_Email;
	}


	public String getPind_video_orifile() {
		return pind_video_orifile;
	}

	public void setPind_video_orifile(String pind_video_orifile) {
		this.pind_video_orifile = pind_video_orifile;
	}

	public String getPind_video_savedfile() {
		return pind_video_savedfile;
	}

	public void setPind_video_savedfile(String pind_video_savedfile) {
		this.pind_video_savedfile = pind_video_savedfile;
	}

	
	public String getPind_video_About() {
		return pind_video_About;
	}

	public void setPind_video_About(String pind_video_About) {
		this.pind_video_About = pind_video_About;
	}
	
	public String getPind_mCategory() {
		return pind_mCategory;
	}

	public void setPind_mCategory(String pind_mCategory) {
		this.pind_mCategory = pind_mCategory;
	}

	public String getPind_video_Nickname() {
		return pind_video_Nickname;
	}

	public void setPind_video_Nickname(String pind_video_Nickname) {
		this.pind_video_Nickname = pind_video_Nickname;
	}

	@Override
	public String toString() {
		return "VideoVO [pind_video_Num=" + pind_video_Num + ", pind_video_Title=" + pind_video_Title
				+ ", pind_video_Date=" + pind_video_Date + ", pind_video_Hits=" + pind_video_Hits
				+ ", pind_video_About=" + pind_video_About + ", pind_video_orifile=" + pind_video_orifile
				+ ", pind_video_savedfile=" + pind_video_savedfile + ", pind_video_Email=" + pind_video_Email
				+ ", pind_mCategory=" + pind_mCategory + ", pind_video_Nickname=" + pind_video_Nickname + "]";
	}


}
