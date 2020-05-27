<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<center>
		<form action="${pageContext.request.contextPath }/Loginservlet2" method="post">
			<table border="1" style="width: 30%">

				<tr align="center">
					<td>用户名：</td>
					<td><input type="text" name="sno" value="" placeholder="用户名">
					</td>
				</tr>

				<tr align="center">
					<td>密码：</td>
					<td><input type="password" name="password" value="" placeholder="密码"></td>
				</tr>

				<tr align="center">
					<td colspan="2">
					
					<input type="submit" value="登录"> 
					<input type="reset" value="重置">
						<a href="regist.jsp">注册</a>
						</td>

				</tr>
			</table>

		</form>
	</center>
</body>
</html>