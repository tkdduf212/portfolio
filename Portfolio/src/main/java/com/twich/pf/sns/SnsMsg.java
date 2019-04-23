package com.twich.pf.sns;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class SnsMsg {
	private BigDecimal ps_no;
	private String ps_owner;
	private String ps_txt;
	private Date ps_date;
	private String ps_color;
	private String ps_img;
	
	private String p_name;
	private String p_img;
	
	private List<SnsReply> ps_repls;
	
	
	public SnsMsg() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SnsMsg(BigDecimal ps_no, String ps_owner, String ps_txt, Date ps_date, String ps_color, String ps_img,
			String p_name, String p_img, List<SnsReply> ps_repls) {
		super();
		this.ps_no = ps_no;
		this.ps_owner = ps_owner;
		this.ps_txt = ps_txt;
		this.ps_date = ps_date;
		this.ps_color = ps_color;
		this.ps_img = ps_img;
		this.p_name = p_name;
		this.p_img = p_img;
		this.ps_repls = ps_repls;
	}



	public String getJm_name() {
		return p_name;
	}

	public void setJm_name(String p_name) {
		this.p_name = p_name;
	}

	public String getJm_photo() {
		return p_img;
	}

	public void setJm_photo(String p_img) {
		this.p_img = p_img;
	}

	public BigDecimal getPs_no() {
		return ps_no;
	}

	public void setPs_no(BigDecimal ps_no) {
		this.ps_no = ps_no;
	}

	public String getPs_owner() {
		return ps_owner;
	}

	public void setPs_owner(String ps_owner) {
		this.ps_owner = ps_owner;
	}

	public String getPs_txt() {
		return ps_txt;
	}

	public void setPs_txt(String ps_txt) {
		this.ps_txt = ps_txt;
	}

	public Date getPs_date() {
		return ps_date;
	}

	public void setPs_date(Date ps_date) {
		this.ps_date = ps_date;
	}

	public String getPs_color() {
		return ps_color;
	}

	public void setPs_color(String ps_color) {
		this.ps_color = ps_color;
	}

	public String getPs_img() {
		return ps_img;
	}

	public void setPs_img(String ps_img) {
		this.ps_img = ps_img;
	}
	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}


	public List<SnsReply> getPs_repls() {
		return ps_repls;
	}


	public void setPs_repls(List<SnsReply> ps_repls) {
		this.ps_repls = ps_repls;
	}
	
}
