package com.twich.pf.sns;

import java.io.File;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.twich.pf.member.Member;

@Service
public class SnsDAO {
	
	private int allMsgCount;
	
	@Autowired
	private SqlSession ss;

	
	public void getAllMsgsCount() {
		allMsgCount = ss.getMapper(SnsMapper.class).getAllSnsMsgsCount();
	}

	private String getRandomColor() {
		String color = "#455A64";
		int r = new Random().nextInt(17);
		if (r == 0) {
			color = "#424242";
		} else if (r == 1) {
			color = "#5D4037";
		} else if (r == 2) {
			color = "#E64A19";
		} else if (r == 3) {
			color = "#FFEB3B";
		} else if (r == 4) {
			color = "#C0CA33";
		} else if (r == 5) {
			color = "#558B2F";
		} else if (r == 6) {
			color = "#388E3C";
		} else if (r == 7) {
			color = "#00796B";
		} else if (r == 8) {
			color = "#0097A7";
		} else if (r == 9) {
			color = "#0288D1";
		} else if (r == 10) {
			color = "#1565C0";
		} else if (r == 11) {
			color = "#303F9F";
		} else if (r == 12) {
			color = "#512DA8";
		} else if (r == 13) {
			color = "#8E24AA";
		} else if (r == 14) {
			color = "#D81B60";
		} else if (r == 15) {
			color = "#D32F2F";
		}
		return color;
	}
	
	public void writeSnsMsg(SnsMsg sm, HttpServletRequest req, HttpServletResponse res){
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		try {
			mr = new MultipartRequest(req, path, 50 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "글 쓰기 실패");
			return;
		}
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			
			sm.setPs_owner(m.getP_id());
			String ps_txt = mr.getParameter("ps_txt");
			if (ps_txt.equals("")) {
				ps_txt = "x";
			}else {
				ps_txt = ps_txt.replace("\r\n", "<br>");
			}
			sm.setPs_txt(ps_txt);
			sm.setPs_color(getRandomColor());
			
			String ps_img = mr.getFilesystemName("ps_img");
			if (ps_img == null) {
				ps_img = "x";
			}else {
				ps_img = URLEncoder.encode(ps_img,"utf-8");
				ps_img = ps_img.replace("+", " ");
			}
			sm.setPs_img(ps_img);
			if (ss.getMapper(SnsMapper.class).writeSNSMsg(sm) == 1) {
				req.setAttribute("r", "글쓰기 성공");
				allMsgCount++;
			}
		} catch (Exception e) {
			req.setAttribute("r", "글쓰기 실패");
			File f = new File(path + "/"+ mr.getFilesystemName("ps_img"));
			f.delete();
			e.printStackTrace();
		}
		
	}
	
	public void updateSnsMsag(SnsMsg sm, HttpServletRequest req, HttpServletResponse res){
		try {
			if (ss.getMapper(SnsMapper.class).updateSnsMsg(sm) == 1){
				req.setAttribute("r", "수정 성공");
			}
		} catch (Exception e) {
			req.setAttribute("r", "수정 실패");
		}
	}
	
	public void deleteSnsMsag(SnsMsg sm, HttpServletRequest req, HttpServletResponse res){
		try {
			SnsMsg sm2 = ss.getMapper(SnsMapper.class).getSnsMsg(sm);
			if (ss.getMapper(SnsMapper.class).deleteSnsMsg(sm) == 1){
				req.setAttribute("r", "삭제 성공");
				allMsgCount--;
				
				String ps_img = sm2.getPs_img();
				ps_img = URLDecoder.decode(ps_img,"utf-8");
				String path = req.getSession().getServletContext().getRealPath("resources/img");
				File f = new File(path+"/"+ps_img);
				f.delete();
				
			}
		} catch (Exception e) {
			req.setAttribute("r", "삭제 실패");
		}
	}
	
	public void setPage(int pageNo, HttpServletRequest req) {
		req.getSession().setAttribute("pageNo", pageNo);
	}
	
	public void paging(HttpServletRequest req, HttpServletResponse res){
		
		Integer pageNo = (Integer) req.getSession().getAttribute("pageNo");
		if(pageNo == null){
			pageNo = 1;
		}
		double count = 3.0;
		req.setAttribute("curPage", pageNo);
		
		if (allMsgCount > 0) {
			int pageCount = (int) Math.ceil(allMsgCount / count);
			req.setAttribute("pageCount", pageCount);
			int start = (allMsgCount - ((pageNo - 1) * (int) count));
			int end =  (pageNo == pageCount) ? 1 : (start - ((int)count-1));
			SnsMsgNo smn = new SnsMsgNo(new BigDecimal(start), new BigDecimal(end));
			List<SnsMsg> msgs = ss.getMapper(SnsMapper.class).getSnsMsgs(smn);
			for (SnsMsg sm : msgs) {
				sm.setPs_repls(ss.getMapper(SnsMapper.class).getSnsReplys(sm));
			}
			req.setAttribute("msgs", msgs);
		}
	}
	
	public void writeSnsReply(SnsReply sr, HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			sr.setPsr_owner(m.getP_id());
			if (ss.getMapper(SnsMapper.class).writeSnsReply(sr) == 1) {
				req.setAttribute("r", "댓글 쓰기 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "댓글 쓰기 실패");
		}
	}

	public void deleteSnsReply(SnsReply sr, HttpServletRequest req, HttpServletResponse res){
		try {
			if (ss.getMapper(SnsMapper.class).deleteSnsReply(sr)==1) {
				req.setAttribute("r", "댓글 삭제");
			}
		} catch (Exception e) {
			req.setAttribute("r", "댓글 삭제 실패");
		}
	}

}
