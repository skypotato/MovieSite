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
	<div align="center" style="padding: 10px">
		<a href="">예매</a> | <a href="">영화</a> | <a href="">상영시간 조회</a>
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
	<div class="caption"># 영화랭킹(일간순위) #</div>
	<div id="table">
		<div class="header-row row" >
			<span class="cell">순위</span>
			<span class="cell primary">이름</span>
			<span class="cell">개봉일</span>
			<span class="cell">누적관객수</span>
			<span class="cell">누적매출액</span>
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
			} // end for
		%>
	</div>
	<%
		} // end if
	%>
</body>
</html>

