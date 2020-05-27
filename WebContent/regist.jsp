<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
<center>
		<form action="${pageContext.request.contextPath }/Registservlet" method="post">
			<table border="1" style="width: 30%">
			  <tr align="center">
					<td>姓名</td>
					<td><input type="text" name="sname" value="" placeholder="姓名">
					</td>
				</tr>
				<tr align="center">
					<td>学号：</td>
					<td><input type="text" name="sno" value="" placeholder="学号">
					</td>
				</tr>

				<tr align="center">
					<td>密码：</td>
					<td><input type="password" name="password" value="" placeholder="密码"></td>
				</tr>
				
				<tr align="center">
					<td>确定密码：</td>
					<td><input type="password" name="password2" value="" placeholder="密码"></td>
				</tr>

                 <tr align="center">
					<td>电话：</td>
					<td><input type="text" name="phone" value="" placeholder="电话">
					</td>
				</tr>
				
				 <tr align="center">
					<td>性别：</td>
					<td><input type="radio" name="gender" value="男">男
					<input type="radio" name="gender" value="女">女
					</td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="注册"> <input
						type="reset" value="重置"></td>

				</tr>
			</table>

		</form>
	</center>
</body>
</html>