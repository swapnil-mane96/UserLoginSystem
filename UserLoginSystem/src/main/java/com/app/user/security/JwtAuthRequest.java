package com.app.user.security;

import lombok.Data;

/**
 * @author swapnil.mane
 *
 */
@Data
public class JwtAuthRequest {
	
		private String username ;
	    private String password;
	
}
