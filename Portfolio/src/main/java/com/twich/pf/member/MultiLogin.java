package com.twich.pf.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MultiLogin implements HttpSessionBindingListener{
	private static MultiLogin ml = new MultiLogin();
	private static ArrayList<HttpSession> session = new ArrayList<HttpSession>();
	private static ArrayList<String> memberID = new ArrayList<String>();
	
	private MultiLogin() {
		
	}
	
	public static synchronized MultiLogin getMl(){
		return ml;
	}

	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		session.add(event.getSession());
		memberID.add(event.getName());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		session.remove(event.getSession());
		memberID.remove(event.getName());
	}
	
	public void setAttribute(HttpServletRequest req, HttpServletResponse res, String userID){
		req.getSession().setAttribute(userID, this);
	}
	
	public void removeAttribute(HttpServletRequest req, HttpServletResponse res, String userID){
		int count = memberID.indexOf(userID);//어레이리스트 아이디 순번찾아서
		HttpSession sess=session.get(count); //어레이리스트 세션의 같은 번호의 세션 무효화
		sess.invalidate();
	}
	
	public boolean checkMember(String userID){
		return memberID.contains(userID);
	}
}