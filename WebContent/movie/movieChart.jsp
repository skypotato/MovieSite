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
	<div class="caption"># ��ȭ��ŷ(�ϰ�����) #</div>
	<div id="table">
		<%
			if (movieCharts != null) {
		%>
		<div class="header-row row">
			<span class="cell">����</span> <span class="cell primary">�̸�</span> <span
				class="cell">������</span> <span class="cell">����������</span> <span
				class="cell">���������</span>
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
			}
			}
		%>
	</div>
</body>
</html>

