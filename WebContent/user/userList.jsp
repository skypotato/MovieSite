<%@page import="vo.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="vo.MovieList"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="java.util.*"%>

<%
	request.setCharacterEncoding("EUC-KR");
	ArrayList<MemberBean> memberBeans = (ArrayList<MemberBean>) request.getAttribute("memberBeans");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");

	int currentPage = pageInfo.getPage();
	int lastPage = pageInfo.getTotCnt() / 10;
	int startPage = (((int) ((double) currentPage / 10 + 0.9)) - 1) * 10 + 1;
	int endPage = startPage + 9;
	if (endPage > lastPage)
		endPage = lastPage;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/movieChart.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ȭ�˻�</title>
</head>
<body>
	<div align="left">
		<form action="/MovieSite/userList.do" accept-charset="utf-8">
		<select name="mode">
			<option value="name">�̸�</option>
			<option value="phone">��ȭ��ȣ</option>
		</select>
		<input type="text" name="searchText" style="width: 200px" placeholder="�˻�Ű���带 �Է��Ͻñ� �ٶ��ϴ�." />
		<input type="submit" value="�˻�"/>
		</form>
	</div>
	<div id="table">
		<div class="header-row row">
			<span class="cell primary">���̵�</span>
			<span class="cell">�̸�</span>
			<span class="cell">��ȭ��ȣ</span>
		</div>
		<%
			if (memberBeans != null) {
				for (int i = 0; i < memberBeans.size(); i++) {
		%>
		<div class="row">
			<span class="cell primary" data-label="���̵�"><%=memberBeans.get(i).getId()%></span>
			<span class="cell" data-label="�̸�"><%=memberBeans.get(i).getName()%></span>
			<span class="cell" data-label="��ȭ��ȣ"><%=memberBeans.get(i).getPhone()%></span>
		</div>
		<%
			} // end for
			} else {
		%>
		<div align="center">
			<b>�˻��� ����� �����ϴ�.</b>
		</div>
		<%
			} // end if
		%>
	</div>
	<div align="center">
		<%
			if (startPage > 1) {
		%>
		<a href="/MovieSite/movieList.do?page=<%=startPage - 1%>">����������</a>
		<%
			}
		%>
		|
		<%
			for (int i = startPage; i <= endPage; i++) {
		%>
		<%
			if (i == currentPage) {
		%>
		<b><%=i%></b>
		<%
			} else {
		%>
		<a href="/MovieSite/movieList.do?page=<%=i%>"><%=i%></a>
		<%
			}
		%>
		<%
			}
		%>
		|
		<%
			if (endPage < lastPage) {
		%>
		<a href="/MovieSite/movieList.do?page=<%=endPage + 1%>">����������</a>
		<%
			}
		%>
	</div>
</body>
</html>