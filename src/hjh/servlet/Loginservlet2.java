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

import filter.viewsFilter;
import hjh.Class.Student;

@WebServlet("/Loginservlet2")
public class Loginservlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno = request.getParameter("sno");
		String password = request.getParameter("password");
		
		PreparedStatement  pstat = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
		
			
			String url = "jdbc:mysql://localhost:3306/Test?serverTimezone=GMT%2B8&amp;Unicode=true&amp;characterEncoding=utf-8&useSSL=false";
			String sqlString = "select*from student where sno=? and password=?";
			
            Class.forName("com.mysql.cj.jdbc.Driver");
		    connection = DriverManager.getConnection(url, "root", "qwer1793");
		    pstat = connection.prepareStatement(sqlString);
			pstat.setString(1, sno);
			pstat.setString(2, password);
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				Student loginStu = new Student();
				loginStu.setSno(rs.getString("sno"));
				loginStu.setSname(rs.getString("sname"));
				loginStu.setPhone(rs.getString("phone"));
				loginStu.setGender(rs.getString("gender"));
				loginStu.setPassword(rs.getString("password"));
				
				 request.getSession().setAttribute("loginStu", loginStu);
					response.sendRedirect("Queryservlet");
			}else {
					response.getWriter().print("用户名或者密码错误");
				}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(!rs.isClosed())rs.close();
				if(!pstat.isClosed())pstat.close();
				if(!connection.isClosed())connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
