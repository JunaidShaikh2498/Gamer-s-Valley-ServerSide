package com.springboot.gv.controllers;

import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.LoginChecker;
import com.springboot.gv.entities.MessageResponse;

//import com.example.demo.entities.LoginRequest;

import com.springboot.gv.entities.UserInfoResponse;
import com.springboot.gv.repositories.RegisterUserRepo;
import com.springboot.gv.security.JwtUtils;
import com.springboot.gv.security.MyUserDetails;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
	
	 @Autowired
	 AuthenticationManager authManager;
	  
	  //@Autowired
	  //AuthenticationProvider authenticationProvider;

	  @Autowired
	  RegisterUserRepo ru;	 

	  @Autowired
	  PasswordEncoder encoder;

	  @Autowired
	  JwtUtils jwtUtils;
	  
	  

	  @PostMapping("/login")
	  public ResponseEntity<?> authenticateUser(@RequestBody LoginChecker loginRequest) {

		  System.out.println(loginRequest.getUsername()+" : "+loginRequest.getPassword());
		
		  
	    Authentication authentication = authManager.
	        authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        System.out.println(userDetails);
        
        
	    
	    /*String jwtCookie = jwtUtils.generateTokenFromUsername(loginRequest.getUsername());
	    System.out.println(jwtCookie);*/
        
        String jwtToken = jwtUtils.generateTokenFromUsername(loginRequest.getUsername());
        
        //ResponseCookie res_cookie = jwtUtils.generateJwtCookie(userDetails);
        //System.out.println(res_cookie.getName()+ " : "+res_cookie.getValue());
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    /*return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie)
	        .body(new UserInfoResponse(userDetails.getId(),
	                                   userDetails.getUsername(),	                                   
	                                   roles));*/
	    /*return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, res_cookie.toString())
		        .body(new UserInfoResponse(userDetails.getId(),
		                                   userDetails.getUsername(),	                                   
		                                   roles)); */
	    return ResponseEntity.ok()
	            //.header("Authorization", "Bearer " + jwtToken)
	            .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),	                                   
                        roles,jwtToken));
	  }	  

	 
	  
	 @PostMapping("/signout")
	  public ResponseEntity<?> logoutUser() {
	    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
	        .body(new MessageResponse("You've been signed out!"));
	  }
}
