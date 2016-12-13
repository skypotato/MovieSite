<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="vo.TimeInfo"%>
<%@ page import="java.util.*"%>

<%
	request.setCharacterEncoding("EUC-KR");
	ArrayList<TimeInfo> timeArr = (ArrayList<TimeInfo>) request.getAttribute("timeArr");
	ArrayList<Integer> cdlist = new ArrayList<Integer>();
	ArrayList<String> nmlist = new ArrayList<String>();
	for (int i = 0; i < timeArr.size(); i++) {
		cdlist.add(timeArr.get(i).getMovieCd());
		nmlist.add(timeArr.get(i).getMovieNm());
	}

	HashSet hs1 = new HashSet(cdlist);
	HashSet hs2 = new HashSet(nmlist);

	ArrayList<Integer> cdlist2 = new ArrayList<Integer>(hs1);
	ArrayList<Integer> nmlist2 = new ArrayList<Integer>(hs2);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>영화 예매</title>
</head>
<body>
	<div class="regForm" align="center">
		<form name="tiketFrm" method="post"
			action="/MovieSite/ticketTimeList.do">
			<div class="box" align="left">
				<h3>
					<b>영화예매</b>
				</h3>
				<hr>
				영화 선택 <br>
				<select name="mvlist" size="10" style="width: 150px">
					<%
						for (int i = 0; i < cdlist2.size(); i++) {
					%>
					<option value="<%=cdlist2.get(i)%>"><%=nmlist2.get(i)%></option>
					<%
						}
					%>
				</select> <br>
				<!-- <input type="text" class="iText" name="date" placeholder="날짜 입력:yyyy-mm-dd">  -->
				<input type="submit" class="joinBtn" value="시간선택">
			</div>
		</form>

	</div>


</body>
</html>