<%@ page contentType="text/html; charset=EUC-KR"%>
<html>
<head>
<jsp:useBean id="mMgr" class="dao.MemberDao" />
<%
	request.setCharacterEncoding("EUC-KR");
	String id = request.getParameter("id");
	boolean result = mMgr.checkID(id);
%>
<title>ID 중복체크</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div align="center">
		<br /> <b><%=id%></b>
		<%
			if (result) {
				out.println("는 이미 존재한는 ID입니다.<p>");
			} else {
				out.println("는 사용 가능 합니다.<p>");
			}
		%>
		<a href="#" onClick="self.close()">닫기</a>
	</div>
</body>
</html>