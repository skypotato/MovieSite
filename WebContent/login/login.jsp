<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/MovieSite/css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/MovieSite/script/script.js" charset='EUC-KR'>
</script>
<title>로그인</title>
<%
	request.setCharacterEncoding("euc-kr");
	String id = (String) session.getAttribute("idKey");
%>
</head>
<body>
	<div class="top">
		<h3>
			<b>로그인</b>
		</h3>
		<hr>
	</div>
	<div class="loginForm">
		<%
			if (id != null) {
		%>
		<b><%=id%></b>님 환영 합니다.
		<p>제한된 기능을 사용 할 수가 있습니다.
		<p>
			<a href="../logout.do">로그아웃</a>
			<%
				} else {
			%>
		
		<form method="post" name="login" action="/MovieSite/login.do">
			<div class="box">
				<input type="text" name="id" class="iText" placeholder="아이디를 입력하세요"><br>
				<input type="password" name="pass" class="iText" placeholder="비밀번호를 입력하세요"><br>
				<p>
					<span>
					<a href="registerform.jsp" name="join" class="memBtn" style="text-decoration: none">회원가입</a>
					</span>
					&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;
					<span>
					<a href="">아이디 찾기</a>
					&nbsp;|&nbsp;
					<a href="">비밀번호 찾기</a>
					</span>
				</p>
			</div>
			<a href="javascript:void(0);" onClick="loginCheck();" class="loginBtn" style="text-decoration: none">로그인</a>
		</form>
		<%
			}
		%>
	</div>

</body>
</html>