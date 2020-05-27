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

@WebServlet("/deleteServlet")
public class deliteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String delid = request.getParameter("delid");
		System.out.println(delid);
		Connection connection = null;
		PreparedStatement pStat = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/Test?serverTimezone=GMT%2B8&amp;Unicode=true&amp;characterEncoding=utf-8&useSSL=false";
			String sqlString = "delete from student where sno=?";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, "root", "qwer1793");
			pStat = connection.prepareStatement(sqlString);
			pStat.setString(1, delid);
			if(pStat.executeUpdate()>0) {
				response.sendRedirect("Queryservlet");
			}
		
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(!pStat.isClosed()&&pStat!=null)pStat.close();
				if(!connection.isClosed()&&connection!=null)connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
