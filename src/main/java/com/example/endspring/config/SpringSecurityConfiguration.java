package com.example.endspring.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final  CustomJwtAuthenticationFilter customJwtAuthenticationFilter;

    private final JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // We don't need CSRF for this example
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/helloadmin").hasRole("ADMIN")
                .antMatchers("/hellouser").hasAnyRole("ADMIN", "USER")
                .antMatchers("/authenticate", "/v2/api-docs/**", "/configuration/**", "/swagger-resources/**",
                        "/swagger-ui.html/**", "/webjars/**", "/api-docs/**", "/register").permitAll().anyRequest().authenticated()
                .and().exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler).and().
                sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(customJwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class);
    }
}
