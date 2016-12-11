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
<title>�� ����</title>
</head>
<body>
	<div id="table">
		<div class="header-row row">
			<span class="cell primary">��ȭ �ڵ�</span> <span class="cell">��ȭ
				����</span> <span class="cell">�󿵰� ��ȣ</span> <span class="cell">���� �ð�</span>
			<span class="cell">���� �ð�</span>
		</div>
		<%
			if (timeArr != null) {
				for (int i = 0; i < timeArr.size(); i++) {
					timeInfo = timeArr.get(i);
		%>
		<div class="row">
			<span class="cell primary" data-label="��ȭ �ڵ�"><%=timeInfo.getMovieCd()%></span>
			<span class="cell" data-label="��ȭ ����"><%=timeInfo.getMovieNm()%></span>
			<span class="cell" data-label="�󿵰� ��ȣ"><%=timeInfo.getTheaterNum()%></span>
			<span class="cell" data-label="���� �ð�"><%=timeInfo.getStartTime()%></span>
			<span class="cell" data-label="���� �ð�"><%=timeInfo.getEndTime()%></span>
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

</body>
</html>