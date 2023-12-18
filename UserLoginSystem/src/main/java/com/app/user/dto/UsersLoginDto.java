//package com.app.user.dto;
//
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.app.user.entity.Users;
//
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import lombok.Getter;
//import lombok.Setter;
//@Getter
//@Setter
//public class UsersLoginDto implements UserDetails{
//	
//	@Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"+ "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Please Enter a valid email address")
//	private String emailAddress;
//	@NotBlank(message = "Please enter a password")
//	private String password;
//	
//	public UsersLoginDto(Users users) {
//		emailAddress = users.getEmailAddress();
//		password = users.getPassword();
//	}
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return this.emailAddress;
//	}
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//}


