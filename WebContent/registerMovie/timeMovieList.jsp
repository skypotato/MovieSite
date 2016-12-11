<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="vo.TimeInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>

<%
	request.setCharacterEncoding("EUC-KR");
	ArrayList<TimeInfo> timeArr = (ArrayList<TimeInfo>) request.getAttribute("timeArr");
	TimeInfo timeInfo;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/movieChart.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>상영 정보</title>
</head>
<body>
	<div id="table">
		<div class="header-row row">
			<span class="cell primary">영화 코드</span> <span class="cell">영화
				제목</span> <span class="cell">상영관 번호</span> <span class="cell">시작 시간</span>
			<span class="cell">종료 시간</span>
		</div>
		<%
			if (timeArr != null) {
				for (int i = 0; i < timeArr.size(); i++) {
					timeInfo = timeArr.get(i);
		%>
		<div class="row">
			<span class="cell primary" data-label="영화 코드"><%=timeInfo.getMovieCd()%></span>
			<span class="cell" data-label="영화 제목"><%=timeInfo.getMovieNm()%></span>
			<span class="cell" data-label="상영관 번호"><%=timeInfo.getTheaterNum()%></span>
			<span class="cell" data-label="시작 시간"><%=timeInfo.getStartTime()%></span>
			<span class="cell" data-label="종료 시간"><%=timeInfo.getEndTime()%></span>
		</div>
		<%
			} // end for
			} else {
		%>
		<div align="center">
			<b>검색된 결과가 없습니다.</b>
		</div>
		<%
			} // end if
		%>
	</div>

</body>
</html>