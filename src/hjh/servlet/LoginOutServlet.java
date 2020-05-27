package hjh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginOutServlet")
public class LoginOutServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("loginStu", "");
		request.getSession().removeAttribute("loginStu");
		request.getSession().removeAttribute("stuList");
		
		request.getSession().removeAttribute("qsname");
		request.getSession().removeAttribute("qsno");
		request.getSession().removeAttribute("qphone");
		request.getSession().removeAttribute("qgender");
		response.sendRedirect("Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
