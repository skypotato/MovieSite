function inputCheck() {
	if (document.regFrm.id.value == "") {
		alert("ID를 입력 해주세요.");
		document.regFrm.id.focus();
		return;
	} else if (document.regFrm.pass.value == "") {
		alert("패스워드를 입력 해주세요.");
		document.regFrm.pass.focus();
		return;
	} else if (document.regFrm.repass.value == "") {
		alert("패스워드 확인을 해주세요.");
		document.regFrm.repass.focus();
		return;
	} else if (document.regFrm.pass.value != document.regFrm.repass.value) {
		alert("패스워드확인이 일치하지 않습니다.");
		document.regFrm.repass.value = "";
		document.regFrm.repass.focus();
		return;
	} else if (document.regFrm.name.value == "") {
		alert("이름을 입력 해주세요.");
		document.regFrm.name.focus();
		return;
	} else if (document.regFrm.phone.value == "") {
		alert("핸드폰 번호를 입력 해주세요.");
		document.regFrm.name.focus();
		return;
	}
	document.regFrm.submit();
}

function loginCheck() {
	if (document.login.id.value == "") {
		alert("아이디를 입력해 주세요.");
		document.login.id.focus();
		return;
	}
	if (document.login.pass.value == "") {
		alert("비밀번호를 입력해 주세요.");
		document.login.pass.focus();
		return;
	}
	document.login.submit();
}

function idCheck(id) {
	frm = document.regFrm;
	if (id == "") {
		alert("아이디를 입력해 주세요.");
		frm.id.focus();
		return;
	}
	location.href="/MovieSite/idCheck.do?id="+id;
}

function win_close() {
	self.close();
}