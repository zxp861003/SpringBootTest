package com.zxp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 启动类
 * @author Administrator
 *
 */
@SpringBootApplication
@MapperScan("com.zxp.mapper")
public class SpringMainServer {

	public static void main(String[] args) {
		SpringApplication.run(SpringMainServer.class, args);
	}
	
}
