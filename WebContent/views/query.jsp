<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询</title>
</head>
<body>
	<center>
       <h2>用户信息查询</h2>

		<form action="${pageContext.request.contextPath }/Queryservlet" method="post">
		<table border="0" style="width: 60%; text-align: center" >
					
			<tr align="right">
			<td>
			<a href="${pageContext.request.contextPath }/LoginOutServlet">登出</a>
			</td>
			</tr>
			
		</table>
			<table border="1" style="width: 60%">

				<tr> 
					<td colspan="5"><input type="submit" value="查询">
					                <input type="button" value="重置" onclick="myReset()" >
					学号: <input id="qsno" type="text" name="qsno" size="6" value="${qsno}">
					姓名: <input id="qsname" type="text" name="qsname" size="6" value="${qsname}">
					phone: <input id="qphone" type="text" name="qphone" size="12" value="${qphone}">
					
					
					性别:<input id="male" type="radio" name="qgender" value="男" <c:if test="${qgender=='男' }">checked="checked"</c:if> >男
					     <input id="female" type="radio" name="qgender" value="女" <c:if test="${qgender=='女' }">checked="checked"</c:if>>女
					     <input id="all" type="radio" name="qgender" value="不限" <c:if test="${qgender!='女' && qgender!='男' }">checked="checked"</c:if>>不限
				  
					</td>

				</tr>
			<tr align="center" style="font-weight: bold; ">
			<td>学号</td><td>姓名</td><td>性别</td><td>手机号</td><td>操作</td>
			</tr>
				<c:forEach items="${stuList }" var="stu">
					<tr align="center">
						<td>${stu.sno }</td>
						<td>${stu.sname }</td>
						<td>${stu.gender }</td> 
						<td>${stu.phone }</td>
						<td><a href="editor.jsp?sno=${stu.sno}">修改</a>
						    <a href="#" onclick="confirmDel(${stu.sno})">删除</a>
						</td> 
					</tr>
				</c:forEach>
			</table>
		</form>
	</center>

	<script type="text/javascript"> 
	function myReset(){
		
		document.getElementById("qsno").value="";
		document.getElementById("qsname").value="";
		document.getElementById("qphone").value="";
		document.getElementById("all").checked=true;

	} 
	
	function confirmDel(thesno){
		if(window.confirm("您确定删除该学生吗？")){
			document.location="${pageContext.request.contextPath }/deleteServlet?delid=" + thesno;
		}
		
	}
	</script>
</body>
</html>