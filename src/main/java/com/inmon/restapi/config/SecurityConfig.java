package com.inmon.restapi.config;

import com.inmon.restapi.config.security.LoginSuccessHandler;
import com.inmon.restapi.config.security.SecurityFilter;
import com.inmon.restapi.config.security.LoginFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private LoginServiceImpl loginService;

    @Autowired
    LoginFailureHandler failureHandler;

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    AuthenticationProvider authProvider;

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                .antMatchers("/option/**").authenticated()
                .anyRequest().permitAll()
                .and() // 로그인 설정
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(loginSuccessHandler)//로그인 성공시 로직
                .failureHandler(failureHandler)        //로그인 실패시 로직
                .usernameParameter("username")                    //유저 아이디로 넘겨줄 파라미터
                .passwordParameter("password")                //유저 비번으로 넘겨줄 파라미터
                .permitAll()
                .and() // 로그아웃 설정
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.headers(headers -> headers.cacheControl(cache -> cache.disable()));//post 새로고침 양식다시제출 확인 x
        http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable();
    }
}
