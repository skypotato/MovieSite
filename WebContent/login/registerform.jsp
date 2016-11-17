<%@ page contentType="text/html; charset=euc-kr"%>
<html>
<head>
<style>
input {
	border: none;
	width: 100%;
}

table {
	border-collapse: collapse;
	border: 1px gray solid;
}
</style>
<title>회원가입</title>
</head>

<body>
	<h3>
		<b>회원가입</b>
	</h3>
	<hr>
	<table width="80%" align="center" style="border: none">
		<table border="1" align="center">
			<form name="registerForm" method="post" action="registerProc.jsp">
				<tr>
					<td><input type="text" name="mem_id" placeholder="아이디"
						style="width: 69%"> <input type="button" value="중복확인"
						onclick="inputCheck()" style="width: 30%"></td>
				</tr>
				<tr>
					<td><input type="password" name="mem_passwd"
						placeholder="비밀번호"></td>

				</tr>
				<tr>
					<td><input type="password" name="mem_repasswd"
						placeholder="비밀번호 확인"></td>
				</tr>
		</table>
		<table border="1" align="center">
			<tr>
				<td><input type="text" name="mem_name" placeholder="이름"></td>

			</tr>
			<tr>

				<td><input type="text" name="mem_phone"
					placeholder="전화번호(-빼고 넣어주세요)"></td>

			</tr>
		</table>
		<tr>
			<td><input type="submit" value="가입하기"></td>

		</tr>
		</form>
	</table>
</body>
</html>
