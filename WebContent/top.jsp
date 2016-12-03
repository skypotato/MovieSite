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
	<a href="/MovieSite/login/registerform.jsp">회원가입</a> | 
	<a href="movie/movieChart.do">아이디 찾기</a> | 
	<a href="main.do">비밀번호 찾기</a>
	<%
		}
	%>
	&nbsp;&nbsp;&nbsp;
</div>
<div align="center" style="padding: 10px; background: #fff;"> 
	<a href="">예매</a> | 
	<a href="movieList.do">영화</a> | 
	<a href="">상영시간표</a>
</div>
