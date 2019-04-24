package com.twich.pf.member;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@Repository
public class MemberDAO {
	@Autowired
	private SqlSession ss;
	MultiLogin ml = MultiLogin.getMl();
	
	public void mainGo(HttpServletResponse res){
		try {
			res.sendRedirect("/pf");
		} catch (IOException e) {
		}
	}
	
	
	public void year(HttpServletRequest req){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date today = new Date();
		String year1 = sdf.format(today);
		int year = Integer.parseInt(year1);

		ArrayList<Integer> j = new ArrayList<Integer>();
		for (int i = year; i > year-100; i--) {
			j.add(i);
		}
		
		req.setAttribute("year", j);//올해연도 값
	}
	
	public boolean join(Member m, HttpServletRequest req, HttpServletResponse res){
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		File f = null;
		try {
			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
		}
		try {
			String p_id = mr.getParameter("p_id");
			String p_pw = mr.getParameter("p_pw");
			String p_name = mr.getParameter("p_name");
			
			String year = mr.getParameter("year");
			String month = mr.getParameter("month");
			String day = mr.getParameter("day");
			String p_birth = year+"."+month+"."+day;
			
			String p_gender1 = mr.getParameter("p_gender");
			BigDecimal p_gender = new BigDecimal(p_gender1);
			
			String p_adds1 = mr.getParameter("p_adds1");
			String p_adds2 = mr.getParameter("p_adds2");
			String p_adds3 = mr.getParameter("p_adds3");
			String p_adds = p_adds1+"*"+p_adds2+"*"+p_adds3; 
			
			String p_img = mr.getFilesystemName("p_img");
			if (p_img != null) {
				p_img = URLEncoder.encode(p_img, "utf-8");
				p_img = p_img.replace("+", " ");
			} else {
				p_img = "non_img.png";
			}
			
			String p_id_hint = mr.getParameter("p_id_hint");
			String p_pw_hint = mr.getParameter("p_pw_hint");

			
			m.setP_id(p_id);
			m.setP_pw(p_pw);
			m.setP_name(p_name);
			m.setP_birth(p_birth);
			m.setP_gender(p_gender);
			m.setP_adds(p_adds);
			m.setP_img(p_img);
			m.setP_id_hint(p_id_hint);
			m.setP_pw_hint(p_pw_hint);
			
			if(ss.getMapper(MemberMapper.class).memberJoin(m) == 1){
				req.setAttribute("r", "환영합니다");
				return true;
			}else {
				req.setAttribute("r", "회원가입 실패");
				f = new File(path+"/"+mr.getFilesystemName("p_img"));
				f.delete();
				return false;
			}
		} catch (Exception e) {
			req.setAttribute("r", "회원가입 실패");
			f = new File(path+"/"+mr.getFilesystemName("p_img"));
			f.delete();
			return false;
		}
	}
	
	public void login(Member m, HttpServletRequest req, HttpServletResponse res){
		try {
			Member dbM = ss.getMapper(MemberMapper.class).getMemberID(m);
			if (dbM != null) {
				if (m.getP_pw().equals(dbM.getP_pw())) {
					if(!ml.checkMember(m.getP_id())){
						req.getSession().setAttribute("loginMember", dbM);
						ml.setAttribute(req, res, m.getP_id());
						req.getSession().setMaxInactiveInterval(24*60*60);
						mainGo(res);
					}else{
						req.setAttribute("r", "로그인 중인 아이디");
					}
				} else {
					req.setAttribute("r", "비밀번호 오류");
				}
			}else {
				req.setAttribute("r", "미가입 ID");
			}
		} catch (Exception e) {
			req.setAttribute("r", "서버오류");
		}
	}

	public boolean logincheck(HttpServletRequest req, HttpServletResponse res){
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("login", "member/LoginOK.jsp");
			return true;
		}
		req.setAttribute("login", "member/Login.jsp");
		return false;
		
	}

	public void logOut( HttpServletRequest req, HttpServletResponse res){
		try {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		ml.removeAttribute(req, res, m.getP_id());
		req.getSession().setAttribute("loginMember", null);
		} catch (Exception e) {
			
		}
	}
	
	public void divideadds(Member m, HttpServletRequest req, HttpServletResponse res){
		m = (Member) req.getSession().getAttribute("loginMember");
		String[] adds = m.getP_adds().split("\\*");
		req.setAttribute("adds1", adds[0]);
		req.setAttribute("adds2", adds[1]);
		req.setAttribute("adds3", adds[2]);
		
		if (m.getP_gender().intValue() == 1) {
			req.setAttribute("gender", "남");
		} else if (m.getP_gender().intValue() == 2) {
			req.setAttribute("gender", "여");
		}
	}
	
	public boolean update(Member m, HttpServletRequest req, HttpServletResponse res){
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		File f = null;
		try {
			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
		}
		try {
			String p_id = mr.getParameter("p_id");
			String p_pw = mr.getParameter("p_pw");
			String p_name = mr.getParameter("p_name");
			String p_adds1 = mr.getParameter("p_adds1");
			String p_adds2 = mr.getParameter("p_adds2");
			String p_adds3 = mr.getParameter("p_adds3");
			String p_adds = p_adds1+"*"+p_adds2+"*"+p_adds3; 
			
			String p_img = mr.getFilesystemName("p_img");
			
			Member loginMember = (Member) req.getSession().getAttribute("loginMember");
			if (p_img != null) {
				p_img = URLEncoder.encode(p_img, "utf-8");
				p_img = p_img.replace("+", " ");
				if (!loginMember.getP_img().equals("non_img.png")) {
					String p_img_before = loginMember.getP_img();
					p_img_before = URLDecoder.decode(p_img_before, "utf-8");
					File f1 = new File(path + "/" + p_img_before);
					f1.delete();
				}
			} else {
				p_img = loginMember.getP_img();
			}
			
			String p_id_hint = mr.getParameter("p_id_hint");
			String p_pw_hint = mr.getParameter("p_pw_hint");

			
			m.setP_id(p_id);
			m.setP_pw(p_pw);
			m.setP_name(p_name);
			m.setP_adds(p_adds);
			m.setP_img(p_img);
			m.setP_id_hint(p_id_hint);
			m.setP_pw_hint(p_pw_hint);
			
			if(ss.getMapper(MemberMapper.class).memberUpdate(m) == 1){
				req.getSession().setAttribute("loginMember", m);
				req.getSession().setMaxInactiveInterval(24*60*60);
				req.setAttribute("r", "수정 완료");
				return true;
			}else {
				req.setAttribute("r", "수정 실패");
				f = new File(path+"/"+mr.getFilesystemName("p_img"));
				f.delete();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "수정 실패");
			divideadds(m, req, res);
			f = new File(path+"/"+mr.getFilesystemName("p_img"));
			f.delete();
			return false;
		}
	}

	public void bye(Member m, HttpServletRequest req, HttpServletResponse res){
		try {
			m = (Member) req.getSession().getAttribute("loginMember");
			if (ss.getMapper(MemberMapper.class).memberBye(m)==1) {
				req.setAttribute("r", "탈퇴 성공");
				String p_img = m.getP_img();
				p_img = URLDecoder.decode(p_img, "utf-8");
				String path = req.getSession().getServletContext().getRealPath("resources/img");
				File f = new File(path +"/"+p_img);
				if (!p_img.equals("non_img.png")) {
					f.delete();
				}
				logOut(req, res);
			}
		} catch (Exception e) {
			req.setAttribute("r", "탈퇴 실패");
		}
	}
	
	public Members idCheck(Member m, HttpServletRequest req, HttpServletResponse res){
		try {
			Member dbM = ss.getMapper(MemberMapper.class).getMemberID(m);
			ArrayList<Member> al =  new ArrayList<Member>();
			al.add(dbM);
			Members ms = new Members(al);
			return ms;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
