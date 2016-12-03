<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@page import="vo.MovieChart"%>
<%@ page import="java.util.*"%>

<%
	request.setCharacterEncoding("EUC-KR");
	ArrayList<MovieChart> movieCharts = (ArrayList<MovieChart>) request.getAttribute("movieCharts");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/movieChart.css">
<meta charset="EUC-KR" />
<title>JSON �Ľ�</title>
</head>
<body>
	<div align="center" style="padding: 10px">
		<a href="">����</a> | <a href="">��ȭ</a> | <a href="">�󿵽ð� ��ȸ</a>
	</div>
	<%
		if (movieCharts != null) {
	%>
	<div align="center">
		<%
			for (int i = 0; i < movieCharts.size(); i++) {
		%>
			<span><img src="<%=movieCharts.get(i).getImage()%>"/></span>
		<%
			} // end for
		%>
	</div>
	<div class="caption"># ��ȭ��ŷ(�ϰ�����) #</div>
	<div id="table">
		<div class="header-row row" >
			<span class="cell">����</span>
			<span class="cell primary">�̸�</span>
			<span class="cell">������</span>
			<span class="cell">����������</span>
			<span class="cell">���������</span>
		</div>
		<%
			for (int i = 0; i < movieCharts.size(); i++) {
		%>
		<div class="row">
			<span class="cell" data-label="����"><%=movieCharts.get(i).getRank()%></span>
			<span class="cell primary" data-label="�̸�"><%=movieCharts.get(i).getMovieNm()%></span>
			<span class="cell" data-label="������"><%=movieCharts.get(i).getOpenDt()%></span>
			<span class="cell" data-label="����������"><%=movieCharts.get(i).getAudiAcc()%></span>
			<span class="cell" data-label="���������"><%=movieCharts.get(i).getSalesAcc()%></span>
		</div>
		<%
			} // end for
		%>
	</div>
	<%
		} // end if
	%>
</body>
</html>

