<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String top= (String)request.getAttribute("top");
	String center=(String)request.getAttribute("center");
	String bottom=(String)request.getAttribute("bottom");
%>
<html>
<head>
<title>Skypotato</title>
</head>
<body>
	<table style="width: 100%; height: 100%">
		<tr height="7%" bgcolor="#FFBB00">
			<td><jsp:include page="<%=top %>"/></td>
		</tr>
		<tr>
			<td><jsp:include page="<%=center %>"/></td>
		</tr>
		<tr height="10%" bgcolor="#FFBB00">
			<td><jsp:include page="<%=bottom %>"/></td>
		</tr>
	</table>
</body>
</html>