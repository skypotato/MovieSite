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
	<a href="/MovieSite/login/registerform.jsp">ȸ������</a>
	<%
		}
	%>
	&nbsp;&nbsp;&nbsp;
</div>
<%
	if ("admin".equals(id)) {
%>
<div align="center" style="padding: 10px; background: #fff;"> 
	<a href="">������Ȯ��</a> |  
	<a href="/MovieSite/registerMovieList.do">��ȭ���</a> |
	<a href="/MovieSite/timeList.do">�󿵸��</a> 
</div>
<%	} else { %>
<div align="center" style="padding: 10px; background: #fff;"> 
	<a href="">����</a> | 
	<a href="/MovieSite/movieList.do">��ȭ</a> | 
	<a href="">�󿵽ð�ǥ</a>
</div>
<%	} %>
