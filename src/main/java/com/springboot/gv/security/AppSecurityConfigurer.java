package com.springboot.gv.security;

import java.time.Duration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.springboot.gv.security.MyUserDetailsService;

@Configuration
public class AppSecurityConfigurer {
	
	@Autowired
	private AuthEntryPointJwt point;
	
	@Bean
	AuthTokenFilter authTokenFilter() {
		return new AuthTokenFilter();
	};
	/*@Autowired
	AuthTokenFilter authTokenFilter;*/
	
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
	 
		return builder
			.setConnectTimeout(Duration.ofMillis(3000))
			.setReadTimeout(Duration.ofMillis(3000))
			.build();
	}
	
	
	@Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000");
        config.addAllowedHeader("*");
        config.addExposedHeader("Authorization");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return source;
    }
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/register").permitAll()
        .antMatchers("/user").hasAuthority("USER")
		.antMatchers("/admin").hasAuthority("ADMIN")
		.and()
		.formLogin();*/
		http.cors(cors -> cors.configurationSource(corsConfigurationSource()));
		http.csrf(csrf -> csrf.disable())
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		http.authorizeHttpRequests(authorize -> {
			authorize.requestMatchers(new AntPathRequestMatcher("/")).permitAll();
			authorize.requestMatchers(new AntPathRequestMatcher("/cats")).permitAll();
			authorize.requestMatchers(new AntPathRequestMatcher("/about")).permitAll();
			authorize.requestMatchers(new AntPathRequestMatcher("/login")).permitAll();
			authorize.requestMatchers(new AntPathRequestMatcher("/saveExp")).permitAll();
			authorize.requestMatchers(new AntPathRequestMatcher("/save")).permitAll();
//			authorize.requestMatchers(new AntPathRequestMatcher("/getquestions")).permitAll();
			authorize.antMatchers("/admin").hasAuthority("Admin");
//			authorize.antMatchers("/home").hasAuthority("Admin");
			authorize.antMatchers("/getquestions").hasAnyAuthority("Customer","Expert","Admin");
			authorize.antMatchers("/getanswer/*").hasAnyAuthority("Customer","Expert","Admin");
			authorize.antMatchers("/expert_list").hasAuthority("Admin");
			authorize.antMatchers("/add-category").hasAuthority("Admin");
			authorize.antMatchers("/addProduct/*").hasAuthority("Admin");
			authorize.antMatchers("/*/updatePrice").hasAuthority("Admin");
			authorize.antMatchers("/editProfileE").hasAuthority("Expert");
			authorize.antMatchers("/getCustByRegId/*").hasAuthority("Customer");
			authorize.antMatchers("/givefeedback/*").hasAuthority("Customer");
			authorize.antMatchers("/updateC/*").hasAuthority("Customer");
			authorize.antMatchers("/deleteCartItem/*").hasAuthority("Customer");
			authorize.antMatchers("/answer/**").hasAuthority("Expert");
			authorize.antMatchers("/ask/*").hasAuthority("Customer");
			authorize.antMatchers("/placeOrder").hasAuthority("Customer");
			authorize.antMatchers("/faq_list/*").hasAnyAuthority("Customer","Expert");
			authorize.antMatchers("/orderlist").hasAuthority("Admin");
			//authorize.antMatchers("/cats").permitAll();
//			authorize.requestMatchers(new AntPathRequestMatcher("")).hasAuthority("Admin");
//			authorize.requestMatchers(new AntPathRequestMatcher("/")).permitAll();
//			authorize.requestMatchers("/uploadimg/**").permitAll();
//			authorize.requestMatchers("/dotnetapi").permitAll();
//			authorize.requestMatchers("/getRegRequests").hasAuthority("ADMIN");
//			authorize.requestMatchers("/approve").hasAuthority("ADMIN");
//			authorize.requestMatchers("/getDoctor").hasAuthority("DOCTOR");
			//authorize.requestMatchers("/c").hasAuthority("USER");
			//authorize.requestMatchers("/admin").hasAnyAuthority("ADMIN","USER");
			
		});
		//.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
        
		//http.cors(cors -> cors.configurationSource());
		
		
		return http.build();
    }
	
	@Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider  = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
	
	@Bean
    UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }
	
	/*protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
		
	}*/
	
	@Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

}
