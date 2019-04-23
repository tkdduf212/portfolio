package com.twich.pf.sns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.twich.pf.member.MemberDAO;

@Controller
public class SnsController {
	
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SnsDAO sDAO;
	
	@RequestMapping(value = "/sns.write", method = RequestMethod.POST)
	public String writeSNSMsg(SnsMsg sm, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.logincheck(req, res)) {
			sDAO.writeSnsMsg(sm, req, res);
		}
		sDAO.setPage(1, req);
		sDAO.paging(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/sns.update", method = RequestMethod.GET)
	public String updateSNSMsg(SnsMsg sm, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.logincheck(req, res)) {
			sDAO.updateSnsMsag(sm, req, res);
		}
		sDAO.paging(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/sns.delete", method = RequestMethod.GET)
	public String deleteSNSMsg(SnsMsg sm, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.logincheck(req, res)) {
			sDAO.deleteSnsMsag(sm, req, res);
		}
		sDAO.paging(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/sns.page.change", method = RequestMethod.GET)
	public String pageChange(SnsMsg sm, HttpServletRequest req, HttpServletResponse res) {
		mDAO.logincheck(req, res);
		sDAO.setPage(Integer.parseInt(req.getParameter("p")), req);
		sDAO.paging(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/sns.reply.write", method = RequestMethod.GET)
	public String writeSNSReply(SnsReply sr, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.logincheck(req, res)) {
			sDAO.writeSnsReply(sr, req);
		}
		sDAO.paging(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/sns.reply.delete", method = RequestMethod.GET)
	public String deleteSNSReply(SnsReply sr, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.logincheck(req, res)) {
			sDAO.deleteSnsReply(sr, req, res);
		}
		sDAO.paging(req, res);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
}
