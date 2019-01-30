package com.hwj.banking.Config;

import com.hwj.banking.Dao.CustomerDao;
import com.hwj.banking.Service.CustomerService;
import com.hwj.banking.ServiceImp.CustomerAuthorityServiceImp;
import com.hwj.banking.ServiceImp.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackageClasses = CustomerDao.class)
@Configuration
public class CustomerSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    AuthenticationSuccessHandler authenticationSuccessHandler;

//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
////                .antMatchers("/product/**","/shop/**").authenticated()
////                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()
////                .antMatchers("/main/**").permitAll()
////                .antMatchers("/main/**").hasRole("ADMIN")
////                .antMatchers("/customer/**").hasRole("ADMIN")   // 需要相应的角色才能访问
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()   //基于 Form 表单登录验证
//                .loginPage("/login").failureUrl("/login-error") // 自定义登录界面
//                .and()
//                .exceptionHandling().accessDeniedPage("/4o3"); // 处理异常，拒绝访问就重定向到 403 页面
//        http.logout().logoutSuccessUrl("/home");   // 成功登出后，重定向到 首页
////        http.csrf().ignoringAntMatchers("/h2-console/**"); // 禁用 H2 控制台的 CSRF 防护
////        http.headers().frameOptions().sameOrigin();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }

    @Autowired
    private CustomerAuthorityServiceImp customerAuthorityServiceImp;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.userDetailsService(customerAuthorityServiceImp).passwordEncoder(bCryptPasswordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.csrf().disable();
//                .authorizeRequests()
//                .antMatchers("**/customer/**", "**/main/**").authenticated()
////                .antMatchers("**/customer/**", "**/main/**").hasRole("USER")
//                .anyRequest().permitAll()
//                .and()
////                .formLogin().permitAll();
//                .formLogin().loginPage("/login").permitAll()
//                .failureUrl("/login?error=true")
//                .defaultSuccessUrl("/welcome")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/").and().exceptionHandling()
//                .accessDeniedPage("/access-denied");
//        System.out.println("++++++++++++++++++++++++++++++++++");



        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/main/**", "/customer/**").authenticated()
//                .antMatchers("/main/**", "/customer/**").hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login")
                .failureUrl("/login-error")
                .defaultSuccessUrl("/welcome")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/login-error");
    }

//    private PasswordEncoder getPasswordEncoder() {
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return charSequence.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return true;
//            }
//        };
//    }
}
