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
	<b><%=id%></b>님 환영 합니다. <a href="logout.do">로그아웃</a>
	<%
		} else {
	%>
	<a href="/MovieSite/login/loginform.jsp">로그인</a> | 
	<a href="/MovieSite/login/registerform.jsp">회원가입</a>
	<%
		}
	%>
	&nbsp;&nbsp;&nbsp;
</div>
<%
	if ("admin".equals(id)) {
%>
<div align="center" style="padding: 10px; background: #fff;"> 
	<a href="">예매율확인</a> |  
	<a href="/MovieSite/registerMovieList.do">영화등록</a> |
	<a href="/MovieSite/timeList.do">상영목록</a> 
</div>
<%	} else { %>
<div align="center" style="padding: 10px; background: #fff;"> 
	<a href="">예매</a> | 
	<a href="/MovieSite/movieList.do">영화</a> | 
	<a href="">상영시간표</a>
</div>
<%	} %>
