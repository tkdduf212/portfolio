package com.twich.pf.member;

import java.math.BigDecimal;
import java.util.Date;

public class Member {
	private String p_id;
	private String p_pw;
	private String p_name;
	private String p_birth;
	private BigDecimal p_gender;
	private String p_adds;
	private String p_img;
	private String p_id_hint;
	private String p_pw_hint;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String p_id, String p_pw, String p_name, String p_birth, BigDecimal p_gender, String p_adds,
			String p_img, String p_id_hint, String p_pw_hint) {
		super();
		this.p_id = p_id;
		this.p_pw = p_pw;
		this.p_name = p_name;
		this.p_birth = p_birth;
		this.p_gender = p_gender;
		this.p_adds = p_adds;
		this.p_img = p_img;
		this.p_id_hint = p_id_hint;
		this.p_pw_hint = p_pw_hint;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_pw() {
		return p_pw;
	}

	public void setP_pw(String p_pw) {
		this.p_pw = p_pw;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_birth() {
		return p_birth;
	}

	public void setP_birth(String p_birth) {
		this.p_birth = p_birth;
	}

	public BigDecimal getP_gender() {
		return p_gender;
	}

	public void setP_gender(BigDecimal p_gender) {
		this.p_gender = p_gender;
	}

	public String getP_adds() {
		return p_adds;
	}

	public void setP_adds(String p_adds) {
		this.p_adds = p_adds;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public String getP_id_hint() {
		return p_id_hint;
	}

	public void setP_id_hint(String p_id_hint) {
		this.p_id_hint = p_id_hint;
	}

	public String getP_pw_hint() {
		return p_pw_hint;
	}

	public void setP_pw_hint(String p_pw_hint) {
		this.p_pw_hint = p_pw_hint;
	}

}
