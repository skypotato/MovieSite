<%@page import="com.mysql.jdbc.StringUtils.SearchMode"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<link rel="stylesheet" type="text/css"
	href="/MovieSite/css/register.css">

<%@page import="vo.Seat"%>
<%@ page import="java.util.*"%>

<%
	request.setCharacterEncoding("EUC-KR");
	ArrayList<Seat> seatlist = (ArrayList<Seat>) request.getAttribute("seats");
	int theater = seatlist.get(0).getTheaterNum();
	String timeid = String.valueOf(request.getAttribute("timeid"));

	int i = 1;
	char temp = 'A';
%>


<title>좌석 예매</title>
</head>
<body>
	<div class="regForm" align="center">
		<div class="box">
			<form name="seat" action="/MovieSite/tiketInsert.do">
				<table align="center">
					<td><h3>SCREEN</h3></td>
				</table>
				<hr>
				<table align="center">
					<td>
						<%
							for (Seat seat : seatlist) {
								if (temp != seat.getRowChar()) {
									temp = seat.getRowChar();
						%>
						<br>
						<%
								}//end if
								if (seat.getState() > 0) {
						%>
						<input type="checkbox" name="seat" value="<%=seat.getRowChar()%>-<%=seat.getColumnNum()%>" disabled="disabled">
						<%
								} else {
 						%>
 						<input type="checkbox" name="seat" value="<%=seat.getRowChar()%>-<%=seat.getColumnNum()%>">
 						<%
 								}//end if
						%>
						<%=seat.getRowChar()%>-<%=seat.getColumnNum()%>
						<%
							}//end for
						%>
						<input type="hidden" name="timeid" value="<%=timeid%>">
						<input type="hidden" name="theater" value="<%=theater%>">
					</td>
				</table>
				<input type="submit" class="joinBtn" value="예매하기">
		</div>
	</div>

	</form>

</body>
</html>