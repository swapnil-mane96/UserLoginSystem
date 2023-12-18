package com.app.user.security;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swapnil.mane
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class JwtAuthResponse {
	//private Integer id;
	private String username;
	//private String lastname;
	private String token;
}
