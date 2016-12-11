<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="vo.MovieChart"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>

<%
	//request.setCharacterEncoding("EUC-KR");
	int movieCd = Integer.parseInt(request.getParameter("movieCd"));
	String movieNm = URLDecoder.decode(request.getParameter("movieNm").toString(), "UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="/MovieSite/css/register.css">
<script type="text/javascript">
	function inputCheck() {
		if (document.mvInFrm.startDate.value == "") {
			alert("시작일을 입력해주세요.")
			document.mvInFrm.startDate.focus();
			return;
		} else if (document.mvInFrm.endDate.value == "") {
			alert("종료일을 입력해주세요.")
			document.mvInFrm.endDate.focus();
			return;
		} else if (document.mvInFrm.startTime.value == document.mvInFrm.endTime.value) {
			alert("시간을 입력해주세요.")
			document.mvInFrm.endTime.focus();
			return;
		} else {
			document.mvInFrm.submit();
		}
	}
</script>
<title>영화 등록</title>
</head>
<body>
	<div class="regForm" align="center">
		<form name="mvInFrm" method="post"
			action="/MovieSite/registerTime.do?movieCd=<%=movieCd%>&movieNm=<%=URLEncoder.encode(movieNm, "UTF-8")%>">
			<div class="box" align="left">
				<h3>
					<b>영화 등록</b>
				</h3>
				영화 번호 :
				<%=movieCd%><br> 영화 제목 :
				<%=movieNm%><br> 상영관 선택 : <select name="theaterNum">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select><br> 시작 날짜 : <input type="text" name="startDate" class="iText"
					placeholder="yyyy-mm-dd"><br> 종료 날짜 : <input
					type="text" name="endDate" class="iText" placeholder="yyyy-mm-dd"><br>
				시작 시간 : <select name="startTime">
					<script>
						for (i = 0; i < 48; i++) {
							var hour = '';
							var min = ':00';

							if ((Math.ceil(i / 2)) < 10) {
								hour = '0' + (Math.floor(i / 2));
							} else {
								hour = (Math.floor(i / 2));
							}
							if (i % 2 != 0) {
								min = ':30';
							}
							document.write('<option value='+hour+min+'>' + hour
									+ min + '</option>');
						}
					</script>
				</select><br> 종료 시간 : <select name="endTime">
					<script>
						for (i = 0; i < 48; i++) {
							var hour = '';
							var min = ':00';

							if ((Math.ceil(i / 2)) < 10) {
								hour = '0' + (Math.floor(i / 2));
							} else {
								hour = (Math.floor(i / 2));
							}
							if (i % 2 != 0) {
								min = ':30';
							}
							document.write('<option value='+hour+min+'>' + hour
									+ min + '</option>');
						}
					</script>
				</select><br> <input type="button" class="joinBtn" value="등록"
					onclick="inputCheck()">
			</div>
		</form>
	</div>

</body>
</html>