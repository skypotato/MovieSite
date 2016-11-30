<%@ page contentType="text/html; charset=euc-kr"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="/MovieSite/css/register.css">
<script type="text/javascript" src="/MovieSite/script/script.js" charset='EUC-KR'></script>
<title>회원가입</title>
</head>
<body>
	<div class="regForm" align="center">
		<form name="regFrm" method="post" action="/MovieSite/insertMember.do">
			<div class="box" align="left">
				<h3>
					<b>회원가입</b>
				</h3>
				<hr>
				<input type="text" name="id" placeholder="아이디" class="iText" >
				<input type="button" value="중복확인" onclick="idCheck(this.form.id.value)"><br>
				<input type="password" name="pass" class="iText" placeholder="비밀번호">
				<input type="password" name="repass" class="iText" placeholder="비밀번호 확인"><br><br>
				<input type="text" name="name" class="iText" placeholder="이름">
				<input type="text" name="phone"	class="iText" placeholder="전화번호(-빼고 넣어주세요)">
				<input type="submit" class="joinBtn" value="가입하기" onclick="inputCheck()">
			</div>
		</form>
	</div>

</body>
</html>
