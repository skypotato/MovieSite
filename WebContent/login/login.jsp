<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/MovieSite/css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/MovieSite/script/script.js" charset='EUC-KR'>
</script>
<title>�α���</title>
<%
	request.setCharacterEncoding("euc-kr");
	String id = (String) session.getAttribute("idKey");
%>
</head>
<body>
	<div class="top">
		<h3>
			<b>�α���</b>
		</h3>
		<hr>
	</div>
	<div class="loginForm">
		<%
			if (id != null) {
		%>
		<b><%=id%></b>�� ȯ�� �մϴ�.
		<p>���ѵ� ����� ��� �� ���� �ֽ��ϴ�.
		<p>
			<a href="../logout.do">�α׾ƿ�</a>
			<%
				} else {
			%>
		
		<form method="post" name="login" action="/MovieSite/login.do">
			<div class="box">
				<input type="text" name="id" class="iText" placeholder="���̵� �Է��ϼ���"><br>
				<input type="password" name="pass" class="iText" placeholder="��й�ȣ�� �Է��ϼ���"><br>
				<p>
					<span>
					<a href="registerform.jsp" name="join" class="memBtn" style="text-decoration: none">ȸ������</a>
					</span>
					&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;
					<span>
					<a href="">���̵� ã��</a>
					&nbsp;|&nbsp;
					<a href="">��й�ȣ ã��</a>
					</span>
				</p>
			</div>
			<a href="javascript:void(0);" onClick="loginCheck();" class="loginBtn" style="text-decoration: none">�α���</a>
		</form>
		<%
			}
		%>
	</div>

</body>
</html>