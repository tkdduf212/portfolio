function drUploadCheck() {

	var dr_title = document.drUploadForm.dr_title;
	var dr_file = document.drUploadForm.dr_file;

	if (isEmpty(dr_title)) {
		alert("!");
		dr_title.value = "";
		dr_title.focus();
		return false;
	} else if (isEmpty(dr_file)) {
		alert("!");
		dr_file.value = "";
		dr_file.focus();
		return false;
	}
	return true;
}

function connectIdCheckEvent() {
	$("#p_id").keyup(function() {
		var id = $(this).val();

		$.ajax({
			url : "member.id.check",
			data : {
				p_id : id
			}, // {파라메터명:값, 파라메터명:값, ...}
			success : function(data) {
				if (data.member[0]) {
					$("#joinIdOk").text("사용불가").css('color','red');
				}else{
					$("#joinIdOk").text("ok").css('color','green');
				}
			}
		});

	});
}

function joinCheck() {
	var p_id = document.joinForm.p_id; 	var p_pw = document.joinForm.p_pw;	var p_pwChk = document.joinForm.p_pwChk;	var p_name = document.joinForm.p_name;	var p_gender = document.joinForm.p_gender;	var p_adds1 = document.joinForm.p_adds1;	var p_adds2 = document.joinForm.p_adds2;	var p_adds3 = document.joinForm.p_adds3;	var p_id_hint = document.joinForm.p_id_hint;	var p_pw_hint = document.joinForm.p_pw_hint;	var p_img = document.joinForm.p_img;
	if (isEmpty(p_id) || containsHS(p_id) || lessThan(p_id, 4)) {
		alert("아이디 확인");
		p_id.value = "";
		p_id.focus();
		return false;
	} else if (isEmpty(p_pw) || notEquals(p_pw, p_pwChk)
			|| notContains(p_pw, "1234567890")
			|| notContains(p_pw, "qwertyuiopasdfghjklzxcvbnm")) {
		alert("비밀번호 확인");
		p_pw.value = "";
		p_pwChk.value = "";
		p_pw.focus();
		return false;
	} else if (isEmpty(p_name)) {
		alert("이름쓰세요");
		p_name.value = "";
		p_name.focus();
		return false;
	} else if (p_gender.value == 0) {
		alert("성별확인");
		return false;
	} else if (isEmpty(p_adds1) || isEmpty(p_adds2) || isEmpty(p_adds3)) {
		alert("주소 확인");
		p_adds1.value = "";
		p_adds2.value = "";
		p_adds3.value = "";
		p_adds1.focus();
		return false;
	}else if (isEmpty(p_id_hint)) {
		alert("아이디 힌트 확인");
		return false;
	}else if (isEmpty(p_pw_hint)) {
		alert("비번 힌트 확인");
		return false;
	} else if (isEmpty(p_img)) {
		var ok = confirm("사진없는데 괜찮?");
		if (ok) {
			return true;
		}else {
			return false;
		}
	}else if (isNotType(p_img, "png") && isNotType(p_img, "jpg")&& isNotType(p_img, "gif") && isNotType(p_img, "bmp") && isNotType(p_img, "jpeg")) {
		alert("그림확인");
		p_img.value = "";
		return false;
	}
	return false;
}

function updateMemberCheck() {
	var p_id = document.updateForm.p_id;
	var p_pw = document.updateForm.p_pw;
	var p_pwChk = document.updateForm.p_pwChk;
	var p_name = document.updateForm.p_name;
	var p_addr1 = document.updateForm.p_addr1;
	var p_addr2 = document.updateForm.p_addr2;
	var p_addr3 = document.updateForm.p_addr3;
	var p_img = document.updateForm.p_img;
	if (isEmpty(p_id) || containsHS(p_id)) {
		alert("!");
		p_id.value = "";
		p_id.focus();
		return false;
	} else if (isEmpty(p_pw) || notEquals(p_pw, p_pwChk)
			|| notContains(p_pw, "1234567890")
			|| notContains(p_pw, "qwertyuiopasdfghjklzxcvbnm")) {
		alert("!");
		p_pw.value = "";
		p_pwChk.value = "";
		p_pw.focus();
		return false;
	} else if (isEmpty(p_name)) {
		alert("!");
		p_name.value = "";
		p_name.focus();
		return false;
	} else if (isEmpty(p_addr1) || isEmpty(p_addr2) || isEmpty(p_addr3)) {
		alert("!");
		p_addr1.value = "";
		p_addr2.value = "";
		p_addr3.value = "";
		p_addr1.focus();
		return false;
	} else if (isEmpty(p_img)) {
		return true;
	} else if (isNotType(p_img, "png") && isNotType(p_img, "jpg")
			&& isNotType(p_img, "gif") && isNotType(p_img, "bmp")
			&& isNotType(p_img, "jpeg")) {
		alert("!");
		p_img.value = "";
		return false;
	}

	return true;
}

function loginCheck() {
	var p_id = document.loginForm.p_id;
	var p_pw = document.loginForm.p_pw;

	if (isEmpty(p_id) || isEmpty(p_pw)) {
		alert("!");
		p_id.value = "";
		p_pw.value = "";
		p_id.focus();
		return false;
	}
	return true;
}
function snsWriteCheck() {
	var js_txt = document.snsWriteForm.js_txt;
	var js_img = document.snsWriteForm.js_img;

	if (isEmpty(js_img) && isEmpty(js_txt)) {
		alert("!");
		js_txt.value = "";
		return false;
	} else if (isEmpty(js_img)) {
		return true;
	} else if (isNotType(js_img, "png") && isNotType(js_img, "jpg")
			&& isNotType(js_img, "gif") && isNotType(js_img, "bmp")
			&& isNotType(js_img, "jpeg")) {
		alert("!");
		js_img.value = "";
		return false;
	}
	return true;
}
function snsReplWriteCheck(srwf) {
	var jsr_txt = srwf.jsr_txt;

	if (isEmpty(jsr_txt)) {
		alert("!");
		jsr_txt.value = "";
		jsr_txt.focus();
		return false;
	}
	return true;
}
function snsSearchCheck() {
	var js_search = document.snsSearchForm.js_search;
	if (isEmpty(js_search)) {
		alert("!");
		js_search.value = "";
		js_search.focus();
		return false;
	}
	return true;
}