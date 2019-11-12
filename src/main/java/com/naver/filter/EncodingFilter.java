package com.naver.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class EncodingFilter implements Filter {
	
	private String encode;

    public EncodingFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding(this.encode);
		response.setCharacterEncoding(this.encode);
		
		System.out.println("filter in");
		chain.doFilter(request, response);
		System.out.println("filter out");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//fConfig.getServletContext().getInitParameter(name); //전체 파라미터 가져오기
		this.encode = fConfig.getInitParameter("encode");
	}

}
