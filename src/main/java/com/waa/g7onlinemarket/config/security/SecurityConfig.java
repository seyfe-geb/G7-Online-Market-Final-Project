package com.waa.g7onlinemarket.config.security;


import com.waa.g7onlinemarket.models.Role;
import com.waa.g7onlinemarket.repositories.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletResponse;

import static java.lang.String.format;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final Logger logger;
    private final UserRepository userRepository;
    private final JwtTokenFilter jwtTokenFilter;

    @Value("${springdoc.api-docs.path}")
    private String restApiDocPath;
    @Value("${springdoc.swagger-ui.path}")
    private String swaggerPath;

    public SecurityConfig(Logger logger,
                          UserRepository userRepository,
                          JwtTokenFilter jwtTokenFilter) {
        super();

        this.logger = logger;
        this.userRepository = userRepository;
        this.jwtTokenFilter = jwtTokenFilter;

        // Inherit security context in async function calls
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> userRepository
                .findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                format("User: %s, not found", username)
                        )
                ));
    }

    // Set password encoding schema
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            logger.error("Unauthorized request - {}", ex.getMessage());
                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
                        }
                )
                .and();

        // Set permissions on endpoints
        http.authorizeRequests()
                // Swagger endpoints must be publicly accessible
                .antMatchers("/").permitAll()
                .antMatchers(format("%s/**", restApiDocPath)).permitAll()
                .antMatchers(format("%s/**", swaggerPath)).permitAll()
                // public endpoints
                .antMatchers("/**").permitAll()
                .antMatchers("/auth/register-seller","/auth/**").permitAll()
                .antMatchers(HttpMethod.GET, "/products/**").permitAll()
                .antMatchers(HttpMethod.GET,"/users/profile/*").permitAll()
                // private endpoints
                .antMatchers(HttpMethod.GET,"/users").hasAuthority(Role.ADMIN)
                .antMatchers(HttpMethod.GET,"/users/get-unapproved-sellers").hasAuthority(Role.ADMIN)
                .antMatchers(HttpMethod.POST,"/users/**").hasAuthority(Role.ADMIN)
                .antMatchers(HttpMethod.PUT,"/users/**").hasAuthority(Role.ADMIN)
                .antMatchers(HttpMethod.DELETE, "/users/**").hasAuthority(Role.ADMIN)

                //overridden in controller
                .antMatchers("/products/my-products").hasAuthority(Role.SELLER)
                .antMatchers(HttpMethod.POST, "/product/**").hasAuthority(Role.SELLER)
                .antMatchers(HttpMethod.DELETE, "/product/**").hasAuthority(Role.SELLER)
                .antMatchers(HttpMethod.PUT, "/product/**").hasAuthority(Role.SELLER)

                .antMatchers(HttpMethod.POST, "/product-images/**").hasAuthority(Role.SELLER)
                .antMatchers(HttpMethod.DELETE, "/product-images/**").hasAuthority(Role.SELLER)
                .antMatchers(HttpMethod.PUT, "/product-images/**").hasAuthority(Role.SELLER)

                .antMatchers("/shopping-cart/**").hasAuthority(Role.BUYER)

                .antMatchers(HttpMethod.GET, "/orders/**").hasAnyAuthority(Role.BUYER, Role.SELLER)
                .antMatchers(HttpMethod.POST, "/orders").hasAuthority(Role.BUYER)
                .antMatchers(HttpMethod.PUT, "/orders/change-order-status/*/4/**").hasAnyAuthority(Role.SELLER, Role.BUYER)
                .antMatchers(HttpMethod.PUT, "/orders/change-order-status/*/CANCELLED/**").hasAnyAuthority(Role.SELLER, Role.BUYER)
                .antMatchers(HttpMethod.PUT, "/orders/change-order-status/**").hasAuthority(Role.SELLER)

                .antMatchers(HttpMethod.POST,"/reviews").hasAuthority(Role.BUYER)
                .antMatchers(HttpMethod.PUT,"/reviews/*").hasAuthority(Role.BUYER)
                .antMatchers(HttpMethod.DELETE,"/reviews/*").hasAuthority(Role.BUYER)

                //overriden in controller
                .antMatchers(HttpMethod.GET,"/reviews/get-unapproved-reviews").hasAuthority(Role.ADMIN)
                .antMatchers(HttpMethod.PUT,"/reviews/aprrove-review/*").hasAuthority(Role.ADMIN)

                .antMatchers("/payment-methods/**").hasAuthority(Role.BUYER)

                .antMatchers(HttpMethod.GET, "/users-rewards/**").hasAnyAuthority(Role.BUYER, Role.ADMIN)
                .antMatchers(HttpMethod.POST, "/user-rewards/**").hasAuthority(Role.ADMIN)
                .antMatchers(HttpMethod.PUT, "/user-rewards/**").hasAuthority(Role.ADMIN)
                .antMatchers(HttpMethod.DELETE, "/user-rewards/**").hasAuthority(Role.ADMIN)

                .antMatchers(HttpMethod.POST, "/user-follows/**").hasAuthority(Role.BUYER)
                .antMatchers(HttpMethod.PUT, "/user-follows/**").hasAuthority(Role.BUYER)
                .antMatchers(HttpMethod.DELETE, "/user-follows/**").hasAuthority(Role.BUYER)

                .antMatchers(HttpMethod.GET, "/user-addresses/**").hasAnyAuthority(Role.BUYER, Role.SELLER)
                .antMatchers(HttpMethod.POST, "/user-addresses/**").hasAuthority(Role.BUYER)
                .antMatchers(HttpMethod.PUT, "/user-addresses/**").hasAuthority(Role.BUYER)
                .antMatchers(HttpMethod.DELETE, "/user-addresses/**").hasAuthority(Role.BUYER)

                .antMatchers(HttpMethod.GET, "/user-addresses/list/**").hasAnyAuthority(Role.BUYER, Role.SELLER)
                .antMatchers(HttpMethod.POST, "/user-addresses/list/**").hasAuthority(Role.BUYER)
                .antMatchers(HttpMethod.PUT, "/user-addresses/list/**").hasAuthority(Role.BUYER)
                .antMatchers(HttpMethod.DELETE, "/user-addresses/list/**").hasAuthority(Role.BUYER)

                .anyRequest().authenticated();

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Override @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
