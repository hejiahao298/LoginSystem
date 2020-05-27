<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改</title>
</head>
<body>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/Test?serverTimezone=GMT%2B8&amp;Unicode=true&amp;characterEncoding=utf-8&useSSL=false";
String sql = "select * from student where sno=?";
String sno = request.getParameter("sno");
response.getWriter().print(sno);
Connection connection = DriverManager.getConnection(url, "root", "qwer1793");
PreparedStatement pstat = connection.prepareStatement(sql);
pstat.setString(1, sno);
 ResultSet rs = pstat.executeQuery();
 
 if(rs.next()){
	 pageContext.setAttribute("sno", rs.getString("sno"));
	 pageContext.setAttribute("sname", rs.getString("sname"));
	 pageContext.setAttribute("password", rs.getString("password"));
	 pageContext.setAttribute("password2", rs.getString("password"));
	 pageContext.setAttribute("phone", rs.getString("phone"));
	 pageContext.setAttribute("gender", rs.getString("gender"));
 }
 
%>
<center>
  <h2> 用户信息修改</h2>
		<form action="${pageContext.request.contextPath }/seveServlet" method="post">
			<table border="1" style="width: 30%">
			  <tr align="center">
					<td>姓名</td>
					<td><input type="text" name="sname" value="${sname }" placeholder="姓名">
					</td>
				</tr>
				<tr align="center">
					<td>学号：</td>
					<td><input type="text" name="sno" value="${sno }" placeholder="学号">
					</td>
				</tr>

				<tr align="center">
					<td>密码：</td>
					<td><input type="password" name="password" value="${password }" placeholder="密码"></td>
				</tr>
				
				<tr align="center">
					<td>确定密码：</td>
					<td><input type="password" name="password2" value="${password2 }" placeholder="密码"></td>
				</tr>

                 <tr align="center">
					<td>电话：</td>
					<td><input type="text" name="phone" value="${phone }" placeholder="电话">
					</td>
				</tr>
				
				 <tr align="center">
					<td>性别：</td>
					<td><input type="radio" name="gender" value="男" <c:if test="${gender=='男' }"> checked="checked"</c:if>>男
					
					<input type="radio" name="gender" value="女" <c:if test="${gender=='女' }"> checked="checked"</c:if>>女
					</td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="保持"> <input
						type="reset" value="重置"></td>

				</tr>
			</table>

		</form>
	</center>
</body>
</html>