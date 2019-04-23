function goJoin() {
	location.href = "member.join.go";
}

function logout() {
	if (confirm("?")) {
		location.href = "go.logOut";
	}
}

function memberBye() {
	if (confirm("탈퇴?")) {
		location.href = "bye";
	}
}

function memberUpdate() {
	location.href = "member.update.go";
}

function snsMsgDelete(ps_no) {
	if (confirm("?")) {
		location.href = "sns.delete?ps_no=" + ps_no;
	}
}

function snsMsgUpdate(ps_no, ps_txt) {
	ps_txt = prompt("뭐", ps_txt);
	if (!ps_txt && ps_txt.length > 300) {
		alert("300자 이하로");
	} else {
		location.href = "sns.update?ps_no=" + ps_no + "&ps_txt=" + ps_txt;
	}
}

function snsReplDelete(psr_no) {
	if (confirm("댓글 삭제?")) {
		location.href = "sns.reply.delete?psr_no="+ psr_no;
	}
}
