package com.twich.pf.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twich.pf.sns.SnsDAO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SnsDAO sDAO;

	@RequestMapping(value = "/do.login", method = RequestMethod.POST)
	public String login(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.login(m, req, res);
		mDAO.logincheck(req, res);
		sDAO.paging(req, res);
		req.setAttribute("contentPage", "main.jsp");
		return "index";
	}

	@RequestMapping(value = "/go.join", method = RequestMethod.GET)
	public String goJoin(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.year(req);
		mDAO.logincheck(req, res);
		req.setAttribute("contentPage", "member/JoinPage.jsp");
		return "index";
	}

	@RequestMapping(value = "/do.join", method = RequestMethod.POST)
	public String doJoin(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.join(m, req, res)) {
			req.setAttribute("login", "member/Login.jsp");
			req.setAttribute("contentPage", "main.jsp");
			return "index";
		} else {
			mDAO.year(req);
			mDAO.logincheck(req, res);
			req.setAttribute("contentPage", "member/JoinPage.jsp");
			return "index";
		}
	}

	@RequestMapping(value = "/member.id.check", method = RequestMethod.GET, 
			produces = "application/json; charset=utf-8")
	public @ResponseBody Members idCheck(Member m, HttpServletRequest req, HttpServletResponse res) {
		return mDAO.idCheck(m, req, res);
	}
	
	@RequestMapping(value = "/member.update.go", method = RequestMethod.GET)
	public String updateGo(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.logincheck(req, res)) {
			mDAO.divideadds(m, req, res);
			req.setAttribute("contentPage", "member/Update.jsp");
		} else {
			req.setAttribute("contentPage", "main.jsp");
		}
		return "index";
	}
	@RequestMapping(value = "/member.update", method = RequestMethod.POST)
	public String update(Member m, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.logincheck(req, res)) {
			if (mDAO.update(m, req, res)) {
				req.setAttribute("contentPage", "main.jsp");
			}else {
				req.setAttribute("r", "실패");
				req.setAttribute("contentPage", "member/Update.jsp");
			}
		} else {
			req.setAttribute("contentPage", "member/Update.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/go.logOut", method = RequestMethod.GET)
	public String logOut(HttpServletRequest req, HttpServletResponse res) {
		mDAO.logOut(req, res);
		mDAO.logincheck(req, res);
		mDAO.mainGo(res);
		req.setAttribute("contentPage", "main.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/bye", method = RequestMethod.GET)
	public String bye(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.bye(m, req, res);
		mDAO.logincheck(req, res);
		sDAO.paging(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
}
