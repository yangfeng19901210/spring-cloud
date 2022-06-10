package com.yf.config;

import com.yf.dao.SysPermissionDao;
import com.yf.entity.SysPermission;
import com.yf.handle.MyAuthenticationFailureHandler;
import com.yf.handle.MyAuthenticationSuccessHandler;
import com.yf.service.MyUserDetailService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * spring security 配置类
 * @author yangfeng
 * @version 1.0
 * @date 2022-06-01 15:30
 */
@Component   //将该类添加到spring容器中
@EnableWebSecurity //启动spring的过滤器链
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private MyAuthenticationSuccessHandler successHandler;

  @Autowired
  private MyAuthenticationFailureHandler failureHandler;

  @Autowired
  private MyUserDetailService myUserDetailService;

  @Resource
  private SysPermissionDao sysPermissionDao;





  //配置用户认证信息和权限
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("123456")).authorities("showOrder","addOrder","updateOrder","deleteOrder");
//
//    auth.inMemoryAuthentication().withUser("userAdd").password(this.passwordEncoder().encode("123456")).authorities("showOrder","addOrder");
    //动态设置用户
    auth.userDetailsService(myUserDetailService).passwordEncoder(new PasswordEncoder() {
      @Override
      public String encode(CharSequence rawPassword) {
        return null;
      }
      /**
       * 进行密码的匹配验证
       **/
      @Override
      public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder().matches(rawPassword,encodedPassword);
      }
    });



  }

  //配置拦截请求资源
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    //配置拦截所有请求，并设置认证方式为httpBasic
    //http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();

    //修改认证方式为formLogin
//    http.authorizeRequests()
//        .antMatchers("/login").permitAll() //设置登录路径不拦截
//        .antMatchers("/errorLogin").permitAll() //设置登录错误路径允许访问
//        .antMatchers("/showOrder").hasAnyAuthority("showOrder")
//        .antMatchers("/addOrder").hasAnyAuthority("addOrder")
//        .antMatchers("/updateOrder").hasAnyAuthority("updateOrder")
//        .antMatchers("/deleteOrder").hasAnyAuthority("deleteOrder")
//        .antMatchers("/**").fullyAuthenticated().and().formLogin().loginPage("/login").successHandler(successHandler).failureHandler(failureHandler).and().csrf().disable();//关闭跨站点访问

    //动态设置资源拦截请求
    List<SysPermission> allPers = sysPermissionDao.getAllPers();
    ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http
        .authorizeRequests();
    allPers.stream().forEach(p ->{
      authorizeRequests.antMatchers(p.getUrl()).hasAnyAuthority(p.getPermtag());
    });
    authorizeRequests.antMatchers("/login").permitAll().antMatchers("/**").fullyAuthenticated().and().formLogin()
        .loginPage("/login").and().csrf().disable();


  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    // 使用BCrypt加密密码
    return new BCryptPasswordEncoder();
  }
}
