<%@ page contentType="text/html; charset=EUC-KR"%>
<html>
<head>
<jsp:useBean id="mMgr" class="dao.MemberDao" />
<%
	request.setCharacterEncoding("EUC-KR");
	String id = request.getParameter("id");
	boolean result = mMgr.checkID(id);
%>
<title>ID �ߺ�üũ</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div align="center">
		<br /> <b><%=id%></b>
		<%
			if (result) {
				out.println("�� �̹� �����Ѵ� ID�Դϴ�.<p>");
			} else {
				out.println("�� ��� ���� �մϴ�.<p>");
			}
		%>
		<a href="#" onClick="self.close()">�ݱ�</a>
	</div>
</body>
</html>