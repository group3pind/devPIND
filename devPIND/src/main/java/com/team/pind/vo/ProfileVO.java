package com.team.pind.vo;

public class ProfileVO {

	String pind_image_savedfile = "";
	String pind_mem_Email = "";
	
	public ProfileVO () {
	}
	
	public ProfileVO(String pind_image_savedfile, String pind_mem_Email) {
		super();
		this.pind_image_savedfile = pind_image_savedfile;
		this.pind_mem_Email = pind_mem_Email;
	}

	public String getPind_image_savedfile() {
		return pind_image_savedfile;
	}

	public void setPind_image_savedfile(String pind_image_savedfile) {
		this.pind_image_savedfile = pind_image_savedfile;
	}

	public String getPind_mem_Email() {
		return pind_mem_Email;
	}

	public void setPind_mem_Email(String pind_mem_Email) {
		this.pind_mem_Email = pind_mem_Email;
	}

	@Override
	public String toString() {
		return "ProfileVO [pind_image_savedfile=" + pind_image_savedfile + ", pind_mem_Email=" + pind_mem_Email + "]";
	}
	
}
