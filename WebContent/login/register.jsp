<%@ page contentType="text/html; charset=euc-kr"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="/MovieSite/css/register.css">
<script type="text/javascript" src="/MovieSite/script/script.js" charset='EUC-KR'></script>
<title>ȸ������</title>
</head>
<body>
	<div class="regForm" align="center">
		<form name="regFrm" method="post" action="/MovieSite/insertMember.do">
			<div class="box" align="left">
				<h3>
					<b>ȸ������</b>
				</h3>
				<hr>
				<input type="text" name="id" placeholder="���̵�" class="iText" >
				<input type="button" value="�ߺ�Ȯ��" onclick="idCheck(this.form.id.value)"><br>
				<input type="password" name="pass" class="iText" placeholder="��й�ȣ">
				<input type="password" name="repass" class="iText" placeholder="��й�ȣ Ȯ��"><br><br>
				<input type="text" name="name" class="iText" placeholder="�̸�">
				<input type="text" name="phone"	class="iText" placeholder="��ȭ��ȣ(-���� �־��ּ���)">
				<input type="submit" class="joinBtn" value="�����ϱ�" onclick="inputCheck()">
			</div>
		</form>
	</div>

</body>
</html>
