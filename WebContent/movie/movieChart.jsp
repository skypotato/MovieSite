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
<title>JSON 파싱</title>
</head>
<body>
	<div class="caption"># 영화랭킹(일간순위) #</div>
	<div id="table">
		<%
			if (movieCharts != null) {
		%>
		<div class="header-row row">
			<span class="cell">순위</span> <span class="cell primary">이름</span> <span
				class="cell">개봉일</span> <span class="cell">누적관객수</span> <span
				class="cell">누적매출액</span>
		</div>
		<%
			for (int i = 0; i < movieCharts.size(); i++) {
		%>
		<div class="row">
			<span class="cell" data-label="순위"><%=movieCharts.get(i).getRank()%></span>
			<span class="cell primary" data-label="이름"><%=movieCharts.get(i).getMovieNm()%></span>
			<span class="cell" data-label="개봉일"><%=movieCharts.get(i).getOpenDt()%></span>
			<span class="cell" data-label="누적관객수"><%=movieCharts.get(i).getAudiAcc()%></span>
			<span class="cell" data-label="누적매출액"><%=movieCharts.get(i).getSalesAcc()%></span>
		</div>
		<%
			}
			}
		%>
	</div>
</body>
</html>

