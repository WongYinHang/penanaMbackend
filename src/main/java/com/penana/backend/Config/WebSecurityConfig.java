package com.penana.backend.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/api/authenticate", "/api/register", "/api/chapter_count", "/api/comment",
                        "/api/story_all", "/api/story_all/{id}", "/api/chapter", "/api/content",
                        "/api/story_all/getstory_genre_sid/{genre_sid}", "/api/story_all/popularity", "/api/user/{id}",
                        "/api/story_all/creator/{creator_by}", "/api/chapter/story_id/{story_id}",
                        "/api/content/chapter_id/{chapter_id}", "/api/comment/chapter_id/{chapter_id}",
                        "/api/comment/parent_id/{parent_id}", "/api/chapter_like/user_id/{user_id}",
                        "/api/chapter_like", "/api/story_bookmark/user_id/{user_id}", "/api/story_bookmark",
                        "/api/story_bookmark/setdelete", "/api/chapter_like/setdelete",
                        "/api/comment/count/{chapter_id}", "/api/chapter_like/count/{chapter_id}",
                        "/api/comment/user_id/{user_id}", "/api/chapter/{id}", "/api/user_follow",
                        "/api/user_follow/setdelete", "/api/chapter_like/{id}")
                .permitAll().anyRequest().authenticated().and().exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
