<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="vo.MovieList"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*" %>

<%
	request.setCharacterEncoding("EUC-KR");
	ArrayList<MovieList> movieLists = (ArrayList<MovieList>) request.getAttribute("movieLists");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");

	int currentPage = pageInfo.getPage();
	int lastPage = pageInfo.getTotCnt() / 10;
	int startPage = (((int) ((double) currentPage / 10 + 0.9)) - 1) * 10 + 1;
	int endPage = startPage + 9;
	if (endPage > lastPage)
		endPage = lastPage;
	
	String searchText = "";
	if(request.getParameter("mode")!=null){
		searchText = URLEncoder.encode(request.getParameter("searchText"));
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/movieChart.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>영화검색</title>
</head>
<body>
	<div align="left">
		<form action="/MovieSite/movieList.do" accept-charset="utf-8">
		<select name="mode">
			<option value="movieNm">영화명</option>
			<option value="director">감독명</option>
		</select>
		<input type="text" name="searchText" style="width: 200px" placeholder="검색키워드를 입력하시기 바랍니다." />
		<input type="submit" value="검색"/>
		</form>
	</div>
	<div id="table">
		<div class="header-row row">
			<span class="cell primary">이름</span>
			<span class="cell">제작연도</span>
			<span class="cell">유형</span>
			<span class="cell">장르</span>
			<span class="cell">감독</span>
		</div>
		<%
			if (movieLists != null) {
				for (int i = 0; i < movieLists.size(); i++) {
		%>
		<div class="row">
			<span class="cell primary" data-label="이름"><%=movieLists.get(i).getMovieNm()%></span>
			<span class="cell" data-label="제작연도"><%=movieLists.get(i).getPrdtYear()%></span>
			<span class="cell" data-label="유형"><%=movieLists.get(i).getTypeNm()%></span>
			<span class="cell" data-label="장르"><%=movieLists.get(i).getRepGenreNm()%></span>
			<span class="cell" data-label="감독"><%=movieLists.get(i).getDirectors()%></span>
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
	<div align="center">
		<%
			if (startPage > 1) {
		%>
		<a href="/MovieSite/movieList.do?mode=<%=request.getParameter("mode")%>&searchText=<%=searchText%>&page=<%=startPage - 1%>">이전페이지</a>
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
		<a href="/MovieSite/movieList.do?mode=<%=request.getParameter("mode")%>&searchText=<%=searchText%>&page=<%=i%>"><%=i%></a>
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
		<a href="/MovieSite/movieList.do?mode=<%=request.getParameter("mode")%>&searchText=<%=searchText%>&page=<%=endPage + 1%>">다음페이지</a>
		<%
			}
		%>
	</div>
</body>
</html>