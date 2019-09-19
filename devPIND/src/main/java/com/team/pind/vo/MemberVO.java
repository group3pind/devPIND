package com.team.pind.vo;

public class MemberVO {
	String pind_mem_Email = "";
	String pind_mem_PW = "";
	String pind_mem_Nickname = "";
	String pind_mem_Joincommit = "";
	
	public MemberVO() {
	}

	public MemberVO(String pind_mem_Email, String pind_mem_PW, String pind_mem_Nickname, String pind_mem_Joincommit) {
		super();
		this.pind_mem_Email = pind_mem_Email;
		this.pind_mem_PW = pind_mem_PW;
		this.pind_mem_Nickname = pind_mem_Nickname;
		this.pind_mem_Joincommit = pind_mem_Joincommit;
	}

	public String getPind_mem_Email() {
		return pind_mem_Email;
	}

	public void setPind_mem_Email(String pind_mem_Email) {
		this.pind_mem_Email = pind_mem_Email;
	}

	public String getPind_mem_PW() {
		return pind_mem_PW;
	}

	public void setPind_mem_PW(String pind_mem_PW) {
		this.pind_mem_PW = pind_mem_PW;
	}

	public String getPind_mem_Nickname() {
		return pind_mem_Nickname;
	}

	public void setPind_mem_Nickname(String pind_mem_Nickname) {
		this.pind_mem_Nickname = pind_mem_Nickname;
	}

	public String getPind_mem_Joincommit() {
		return pind_mem_Joincommit;
	}

	public void setPind_mem_Joincommit(String pind_mem_Joincommit) {
		this.pind_mem_Joincommit = pind_mem_Joincommit;
	}

	@Override
	public String toString() {
		return "Member [pind_mem_Email=" + pind_mem_Email + ", pind_mem_PW=" + pind_mem_PW + ", pind_mem_Nickname="
				+ pind_mem_Nickname + ", pind_mem_Joincommit=" + pind_mem_Joincommit + "]";
	}
}