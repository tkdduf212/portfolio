package com.twich.pf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.twich.pf.member.Member;
import com.twich.pf.member.MemberDAO;
import com.twich.pf.sns.SnsDAO;

@Controller
public class HomeController {
	
	@Autowired
	MemberDAO mDAO;
	
	@Autowired
	SnsDAO sDAO;
	
	private boolean firstReq; // 처음 요청인지 따질 변수
	
	//sqlsession이 아직 생성되지 않았을 수 있음
	
	public HomeController() {
		firstReq = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Member m, HttpServletRequest req, HttpServletResponse res) {
		if(firstReq){
			sDAO.getAllMsgsCount();
			firstReq = false;
		}
		mDAO.logincheck(req, res);
		req.setAttribute("contentPage", "main.jsp");
		return "index";
	}
	@RequestMapping(value = "/bbs", method = RequestMethod.GET)
	public String bbs(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.logincheck(req, res);
		sDAO.setPage(1, req);
		sDAO.paging(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
}
