package hjh.servlet;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Loginservlet")
public class Loginservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno = request.getParameter("sno");
		String password = request.getParameter("password");
		
		Statement  stat = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
		
			
			String url = "jdbc:mysql://localhost:3306/Test?serverTimezone=GMT%2B8&amp;Unicode=true&amp;characterEncoding=utf-8&useSSL=false";

            Class.forName("com.mysql.cj.jdbc.Driver");
		    connection = DriverManager.getConnection(url, "root", "qwer1793");
		    stat = connection.createStatement();
			String sqlString = "select*from student where sno='"+sno+"'";
			rs = stat.executeQuery(sqlString);
			
			if(rs.next()) {
				
				if(rs.getString("password")!=null && rs.getString("password").equals(password)) {
					
					response.sendRedirect("Queryservlet");
				}else {
					response.getWriter().print("用户名或者密码错误");
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(!rs.isClosed())rs.close();
				if(!stat.isClosed())stat.close();
				if(!connection.isClosed())connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
