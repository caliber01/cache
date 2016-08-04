package ua.nure.cache.filters;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PreProcessFilter implements Filter {

    public PreProcessFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		HttpServletResponse servletResponse = (HttpServletResponse) response;
		servletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		servletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
		servletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with, X-Auth-Token, Content-Type, origin, accept");
		servletResponse.setHeader("Access-Control-Allow-Credentials", "true");
		servletResponse.setHeader("Access-Control-Max-Age", "3600");

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
