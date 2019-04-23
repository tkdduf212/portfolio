package com.twich.pf.member;

import java.util.ArrayList;

public class Members {
	
	private ArrayList<Member> members;
	
	public Members() {
		// TODO Auto-generated constructor stub
	}

	public Members(ArrayList<Member> member) {
		super();
		this.members = member;
	}

	public ArrayList<Member> getMember() {
		return members;
	}
	public void setMember(ArrayList<Member> member) {
		this.members = member;
	}
	
}
