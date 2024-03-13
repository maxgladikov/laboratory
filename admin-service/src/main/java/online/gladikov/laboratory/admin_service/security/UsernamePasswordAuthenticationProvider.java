package org.aston.ems.admin_service.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider{
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		UserDetails u = userDetailsService.loadUserByUsername(username);
		if (passwordEncoder.matches(password, u.getPassword())) {
			return new UsernamePasswordAuthenticationToken(
					username,
					password,
					u.getAuthorities());
		} else {
			log.debug("Bad credentials!!");
			throw new BadCredentialsException("Something went wrong!");
		}
	}

	@Override
	public boolean supports(Class<?> authenticationType) {
		return authenticationType
			.equals(UsernamePasswordAuthenticationToken.class);
	}


}
