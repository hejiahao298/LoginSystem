package hjh.servlet;


import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hjh.Class.Student;
import java.util.List;

@WebServlet("/Queryservlet")
public class Queryservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null; 
		PreparedStatement pStat = null;
		ResultSet rs = null;
		
		
		
		String qsno = request.getParameter("qsno");
		if(qsno==null)qsno="";
		String qsname = request.getParameter("qsname");
		if(qsname==null)qsname="";
		String qphone = request.getParameter("qphone");
		if(qphone==null)qphone="";
		String qgender = request.getParameter("qgender");
		if(qgender==null)qgender="";
		
		try {
			String url = "jdbc:mysql://localhost:3306/Test?serverTimezone=GMT%2B8&amp;Unicode=true&amp;characterEncoding=utf-8&useSSL=false";
			String sqlString = "select * from student where sno like ? and sname like ? and phone like ? ";
			if(qgender.equals("男") || qgender.equals("女")) {
				sqlString +="and gender=?";
			}
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root", "qwer1793");
			
			pStat = connection.prepareStatement(sqlString);
			pStat.setString(1,"%"+qsno+"%");
			pStat.setString(2,"%"+qsname+"%");
			pStat.setString(3,"%"+qphone+"%");
			if(qgender.equals("男") || qgender.equals("女")) {
			pStat.setString(4, qgender);
			}
			
			rs = pStat.executeQuery();
			List<Student> stuList = new ArrayList<Student>();
			
			while (rs.next()) {
 				Student student = new Student();
 				student.setId(rs.getInt("id"));
 				student.setSno(rs.getString("sno"));
 				student.setPassword(rs.getString("password"));
 				student.setGender(rs.getString("gender"));
 				student.setSname(rs.getString("sname"));
 				student.setPhone(rs.getString("phone"));
				stuList.add(student); 
			}

			
			request.getSession().setAttribute("stuList", stuList);
			
			request.getSession().setAttribute("qsname", qsname);
			request.getSession().setAttribute("qsno", qsno);
			request.getSession().setAttribute("qphone", qphone);
			request.getSession().setAttribute("qgender", qgender);
			//重新刷新前端页面
			response.sendRedirect("views/query.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(!rs.isClosed()&&rs!=null)rs.close();
				if(!pStat.isClosed()&&pStat!=null)pStat.close();
				if(!connection.isClosed()&&connection!=null)connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
