package com.example.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity //Это аннотация помечает класс кот.ответственный за security
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    @Autowired
    public MySecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //    // Никогда так не делай - это только для примера!!!!!!!!!!!!!!!!!
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("nika").password("nika").roles("EMPLOYEE"))
//                .withUser(userBuilder.username("elena").password("elena").roles("HR"))
//                .withUser(userBuilder.username("ivan").password("ivan").roles("MANAGER", "HR"));
//    }
    // Указываем что инфу о наших юзерах содержит база данных. А не прописывать вручную как выше
    // А информация об этом подключении записана в dataSource
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
        // auth.jdbcAuthentication() - это значит инфу брать из БД
        // .dataSource(dataSource) - описывает как подключится к БД
    }

    @Override // Настроим кто может просматривать  какте адреса
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/hr_info").hasRole("HR")
                .antMatchers("/manager_info/**").hasRole("MANAGER").and().formLogin().permitAll();
        // antMatchers("/") - прописать адрес
        // hasAnyRole("EMPLOYEE", "HR", "MANAGER") - какие роли будут иметь доступ по этому адресу
        // .antMatchers("/manager_info/**") - АДРЕС КОТОРЫЙ НАЧИНАЕТС НА manager_info
        // .and().formLogin().permitAll(); - форма логин и пароль будет запрашиватся у всех
    }
}
