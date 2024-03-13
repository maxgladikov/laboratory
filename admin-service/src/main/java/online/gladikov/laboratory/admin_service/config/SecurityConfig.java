package org.aston.ems.admin_service.config;

import org.aston.ems.admin_service.security.UsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UsernamePasswordAuthenticationProvider authenticationProvider;

	@Autowired
	@Qualifier("delegatedAuthenticationEntryPoint")
	AuthenticationEntryPoint authEntryPoint;

	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
				.csrf(AbstractHttpConfigurer::disable)
				.cors(cors -> cors.configurationSource(request -> {
					var corsConfiguration = new CorsConfiguration();
					corsConfiguration.setAllowedOriginPatterns(List.of("*"));
					corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
					corsConfiguration.setAllowedHeaders(List.of("*"));
					corsConfiguration.setAllowCredentials(true);
					return corsConfiguration;
				}))
				.authorizeHttpRequests(authorize -> authorize
					.requestMatchers("/api/v1/admin/auth/**").permitAll()
					.requestMatchers(HttpMethod.POST,"/api/v1/admin/users/**").hasAnyAuthority("ADMIN")
					.requestMatchers(HttpMethod.DELETE,"/api/v1/admin/users/**").hasAnyAuthority("ADMIN")
					.requestMatchers(HttpMethod.PUT,"/api/v1/admin/users/**").hasAnyAuthority("ADMIN")
				.anyRequest().authenticated()
		)
				.sessionManagement(manager -> manager.sessionCreationPolicy(STATELESS))
				.exceptionHandling((exception)-> exception.authenticationEntryPoint(authEntryPoint))
				.httpBasic(withDefaults());
//		http.addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class);
        return http.build();
    }

	@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(authenticationProvider);
	}
	
	@Bean
	InitializingBean initializingBean() {
		return () -> SecurityContextHolder.setStrategyName(
				SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
	}

}
