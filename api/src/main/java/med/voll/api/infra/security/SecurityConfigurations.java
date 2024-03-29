package med.voll.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
	
	
	@Autowired
	private SecurityFilter securityFilter;
	
	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
		  return http.csrf().disable()
                  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                  .and().authorizeHttpRequests()
                  .requestMatchers(HttpMethod.POST, "/login").permitAll() // liberar via posts
                  .anyRequest().authenticated() // liberar somente com autenticao
                  .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) // colocar o filtro do securityFilter  
                  .build();
	}
		  


	@Bean
	public AuthenticationManager autenticationManager( AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
		
				
	}
	@Bean // informar o tipo de codificacao senha
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	
	
	
	
	
}
