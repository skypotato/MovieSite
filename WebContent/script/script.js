function inputCheck() {
	if (document.regFrm.id.value == "") {
		alert("ID�� �Է� ���ּ���.");
		document.regFrm.id.focus();
		return;
	} else if (document.regFrm.pass.value == "") {
		alert("�н����带 �Է� ���ּ���.");
		document.regFrm.pass.focus();
		return;
	} else if (document.regFrm.repass.value == "") {
		alert("�н����� Ȯ���� ���ּ���.");
		document.regFrm.repass.focus();
		return;
	} else if (document.regFrm.pass.value != document.regFrm.repass.value) {
		alert("�н�����Ȯ���� ��ġ���� �ʽ��ϴ�.");
		document.regFrm.repass.value = "";
		document.regFrm.repass.focus();
		return;
	} else if (document.regFrm.name.value == "") {
		alert("�̸��� �Է� ���ּ���.");
		document.regFrm.name.focus();
		return;
	} else if (document.regFrm.phone.value == "") {
		alert("�ڵ��� ��ȣ�� �Է� ���ּ���.");
		document.regFrm.name.focus();
		return;
	}
	document.regFrm.submit();
}

function loginCheck() {
	if (document.login.id.value == "") {
		alert("���̵� �Է��� �ּ���.");
		document.login.id.focus();
		return;
	}
	if (document.login.pass.value == "") {
		alert("��й�ȣ�� �Է��� �ּ���.");
		document.login.pass.focus();
		return;
	}
	document.login.submit();
}

function idCheck(id) {
	frm = document.regFrm;
	if (id == "") {
		alert("���̵� �Է��� �ּ���.");
		frm.id.focus();
		return;
	}
	location.href="/MovieSite/idCheck.do?id="+id;
}

function win_close() {
	self.close();
}