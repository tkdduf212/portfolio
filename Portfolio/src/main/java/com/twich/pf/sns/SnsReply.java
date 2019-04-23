package com.twich.pf.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SnsReply {
	private BigDecimal psr_no;
	private BigDecimal psr_ps_no;
	private String psr_owner;
	private String psr_txt;
	private Date psr_date;
	
	public SnsReply() {
	}

	public SnsReply(BigDecimal psr_no, BigDecimal psr_ps_no, String psr_owner, String psr_txt, Date psr_date) {
		super();
		this.psr_no = psr_no;
		this.psr_ps_no = psr_ps_no;
		this.psr_owner = psr_owner;
		this.psr_txt = psr_txt;
		this.psr_date = psr_date;
	}

	public BigDecimal getPsr_no() {
		return psr_no;
	}

	public void setPsr_no(BigDecimal psr_no) {
		this.psr_no = psr_no;
	}

	public BigDecimal getPsr_ps_no() {
		return psr_ps_no;
	}

	public void setPsr_ps_no(BigDecimal psr_ps_no) {
		this.psr_ps_no = psr_ps_no;
	}

	public String getPsr_owner() {
		return psr_owner;
	}

	public void setPsr_owner(String psr_owner) {
		this.psr_owner = psr_owner;
	}

	public String getPsr_txt() {
		return psr_txt;
	}

	public void setPsr_txt(String psr_txt) {
		this.psr_txt = psr_txt;
	}

	public Date getPsr_date() {
		return psr_date;
	}

	public void setPsr_date(Date psr_date) {
		this.psr_date = psr_date;
	}
}
