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
<title>ȸ������</title>
</head>

<body>
	<h3>
		<b>ȸ������</b>
	</h3>
	<hr>
	<table width="80%" align="center" style="border: none">
		<table border="1" align="center">
			<form name="registerForm" method="post" action="registerProc.jsp">
				<tr>
					<td><input type="text" name="mem_id" placeholder="���̵�"
						style="width: 69%"> <input type="button" value="�ߺ�Ȯ��"
						onclick="inputCheck()" style="width: 30%"></td>
				</tr>
				<tr>
					<td><input type="password" name="mem_passwd"
						placeholder="��й�ȣ"></td>

				</tr>
				<tr>
					<td><input type="password" name="mem_repasswd"
						placeholder="��й�ȣ Ȯ��"></td>
				</tr>
		</table>
		<table border="1" align="center">
			<tr>
				<td><input type="text" name="mem_name" placeholder="�̸�"></td>

			</tr>
			<tr>

				<td><input type="text" name="mem_phone"
					placeholder="��ȭ��ȣ(-���� �־��ּ���)"></td>

			</tr>
		</table>
		<tr>
			<td><input type="submit" value="�����ϱ�"></td>

		</tr>
		</form>
	</table>
</body>
</html>
