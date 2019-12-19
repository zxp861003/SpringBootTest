package com.zxp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 过滤器的实现 
 **/
@WebListener
public class TestListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		System.out.println("listener inited .....");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
