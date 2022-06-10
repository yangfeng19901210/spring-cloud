package com.yf.handle;

import com.yf.entity.SysUser;
import java.io.IOException;

import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

// 认证成功
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication arg2)
			throws IOException, ServletException {
		SysUser user = (SysUser) arg2.getPrincipal();
		System.out.println("用户密码为"+user.getPassword());
//		Collection<GrantedAuthority> authorities = user.getAuthorities();
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		authorities.stream().forEach(t -> System.out.println(t));
		System.out.println("用户认证成功");
		res.sendRedirect("/");
	}

}
