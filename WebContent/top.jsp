<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
	String id = (String) session.getAttribute("idKey");
%>

<div align="right" style="padding: 10px">
	<%
		if (id != null) {
	%>
	<b><%=id%></b>�� ȯ�� �մϴ�. <a href="logout.do">�α׾ƿ�</a>
	<%
		} else {
	%>
	<a href="/MovieSite/login/loginform.jsp">�α���</a> | 
	<a href="/MovieSite/login/registerform.jsp">ȸ������</a> | 
	<a href="movie/movieChart.do">���̵� ã��</a> | 
	<a href="main.do">��й�ȣ ã��</a>
	<%
		}
	%>
	&nbsp;&nbsp;&nbsp;
</div>
<div align="center" style="padding: 10px; background: #fff;"> 
	<a href="">����</a> | 
	<a href="movieList.do">��ȭ</a> | 
	<a href="">�󿵽ð�ǥ</a>
</div>
