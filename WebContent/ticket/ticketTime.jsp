<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="vo.TimeInfo"%>
<%@ page import="java.util.*"%>

<%
	request.setCharacterEncoding("EUC-KR");
	ArrayList<TimeInfo> mvtimeArr = (ArrayList<TimeInfo>) request.getAttribute("timeArr");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form name="tiketFrm2" method="post" action="/MovieSite/seatList.do">
		<div class="box" align="left">
			<h3>
				<b>�ð�</b>
			</h3>
			<hr>
			�ð� ���� <br>
			<select name="mvtime" size="10" style="width: 150px">
				<%
					if (mvtimeArr.size() > 0) {
						for (int i = 0; i < mvtimeArr.size(); i++) {
				%>
				<option value="<%=mvtimeArr.get(i).getTime_id()%>"><%=mvtimeArr.get(i).getStartTime()%></option>
				<%
					}
					}
				%>
			</select> <br> <input type="submit" class="joinBtn" value="�¼�����">
		</div>
	</form>
</body>
</html>