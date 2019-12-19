package com.zxp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/**
 * 拦截器实现
 **/

//@WebFilter(filterName="TestFilter",urlPatterns={"*.do","*.jsp"}) //匹配拦截
//@WebFilter(filterName="TestFilter", urlPatterns="/testHttp")
@WebFilter(filterName="TestFilter", urlPatterns="/*")
public class TestFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req , ServletResponse resp,FilterChain chain) throws IOException, ServletException{
		chain.doFilter(req, resp);
		System.out.println("TestFilter test success");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {
		
	}
	
}
