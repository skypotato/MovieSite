<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setAttribute("top", "/top.jsp");
	request.setAttribute("center", "/ticket/ticketing.jsp");
	request.setAttribute("bottom", "/bottom.jsp");
%>
<jsp:forward page="/template.jsp" />