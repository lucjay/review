package common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/*.do")
public class LoginCheckFilter implements Filter {

	public LoginCheckFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("logincheck pre");
		String id = request.getParameter("id");
		if (id != null && id.equals("admin")) {
			request.getRequestDispatcher("/EmpList.do").forward(request, response);
		}

		chain.doFilter(request, response);

		System.out.println("logincheck post");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
