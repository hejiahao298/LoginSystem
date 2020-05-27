package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.tomcat.util.descriptor.web.LoginConfig;

@WebFilter({ "/viewsFilter", "/views/*", "/*" })
public class viewsFilter implements Filter {

    public viewsFilter() {
    }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String url = req.getRequestURI();
		String Path = req.getContextPath();
		System.out.println("请求的URL为：" + url);
		  if(url.equals("/JDBregist/Login.jsp") || url.equals("/JDBregist/regist.jsp") ||
		   url.equals("/JDBregist/Registservlet") ||   url.equals("/JDBregist/Loginservlet2"))  { 
			  chain.doFilter(request, response);
		 }else if(req.getSession().getAttribute("loginStu")!=null) {
			chain.doFilter(request, response);
		}else {
			resp.sendRedirect(req.getContextPath()+"/Login.jsp");
			
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	public void destroy() {
		
	}

}
