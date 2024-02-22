package com.springboot.gv.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.gv.entities.RegisteredUser;
import com.springboot.gv.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class MyUserDetails implements UserDetails {
	
	  private int id;

	  private String username;
	  
	  private String password;
	  
	  private Role role;

	  private List<? extends GrantedAuthority> authorities;
	  
	  
	  public static MyUserDetails build(RegisteredUser ruser) {
		  	Role r = ruser.getRole();
			//String [] roles = s.split(",");
			List<SimpleGrantedAuthority> authority = new ArrayList<>(); 
			//for(String role : roles)
			//{
				authority.add(new SimpleGrantedAuthority(r.getRole_name()));
			//}
			
			
			System.out.println(authority);
		   System.out.println(ruser);
			return new MyUserDetails( ruser.getRegistrationId(),ruser.getUsername(), ruser.getPassword(), authority );
		  }

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	  
	
	 
	 public MyUserDetails(int id, String uid, String pwd, List<? extends GrantedAuthority> authorities)
		{
			this.id = id;
			this.username  = uid;
			this.password = pwd;
			this.authorities = authorities;
		}
}
