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

@WebServlet("/seveServlet")
public class seveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
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
		 String password2 = request.getParameter("password");
		 if(password2==null)password2="";

		if(!password.equals(password2)) {
			
			response.getWriter().print("两次密码不一致");
			return;
		}
		if(password.length()<=2) {
			response.getWriter().print("密码长度不能小于3位");
			return;
		}
		if(sname.trim().length()==0) {
			response.getWriter().print("学生姓名不能为空");
			return;
		}
		
		
		Connection connection = null;
		PreparedStatement pStat = null;
		try {
			String url = "jdbc:mysql://localhost:3306/Test?serverTimezone=GMT%2B8&amp;Unicode=true&amp;characterEncoding=utf-8&useSSL=false";
			String sql = "update student set sname=?, password=?, gender=?, phone=? where sno=?";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root", "qwer1793");
			pStat = connection.prepareStatement(sql);
			 pStat.setString(1, sname);
			 pStat.setString(2, password);
			 pStat.setString(3, gender);
			 pStat.setString(4, phone);
			 pStat.setString(5, sno);
		   	pStat.executeUpdate();
			 int h = 0;
			 h=pStat.executeUpdate();
			 if(h>0) {
				response.sendRedirect("Queryservlet");
			 }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				if(!pStat.isClosed() && pStat!=null)pStat.close();
				if(!connection.isClosed() && connection!=null)connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	

}
