package com.yf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yf.dao")
public class AppSecurity {

	public static void main(String[] args) {
		SpringApplication.run(AppSecurity.class, args);
		// Security 两种模式 fromLogin 表单提交认证模式 httpBasic 浏览器与服务器做认证授权
	}

}
