package hjh.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registservlet")
public class Registservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection connection =null;
		 PreparedStatement pstat = null;
		
		 
		 String sno = request.getParameter("sno");
		 if(sno==null)sno="";
		 String sname = request.getParameter("sname");
		 if(sname==null)sname="";
		 String password = request.getParameter("password");
		 if(password==null)password="";
		 String phone = request.getParameter("phone");
		 if(phone==null)phone="";
		 String gender = request.getParameter("gender");
		 if(gender==null)gender="";
		 String password2 = request.getParameter("password2");


			if(password.length()<=2) {
				response.getWriter().print("密码长度不能小于3位");
				return;
			}
			if(sname.trim().length()==0) {
				response.getWriter().print("学生姓名不能为空");
				return;
			}
		 
		 if(password.equals(password2)) {
		try {
			
			String sql = "insert into student(sno ,sname , gender , phone , password ) values(?,?,?,?,?)";
			String url = "jdbc:mysql://localhost:3306/Test?serverTimezone=GMT%2B8&amp;Unicode=true&amp;characterEncoding=utf-8&useSSL=false";
		     Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection(url, "root", "qwer1793");
			 pstat=connection.prepareStatement(sql);
			 pstat.setString(1, sno);
			 pstat.setString(2, sname);
			 pstat.setString(3, gender);
			 pstat.setString(4, phone);
			 pstat.setString(5, password);
			 int h = 0;
			 h=pstat.executeUpdate();
			 if(h>0) {
				response.sendRedirect("Login.jsp");
			 }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				if(!pstat.isClosed() && pstat!=null)pstat.close();
				if(!connection.isClosed() && connection!=null)connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}else {
		response.getWriter().print("两次输入的密码不一致");
	}
	}
}
