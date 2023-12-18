package com.app.user.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Swapnil
 *
 */
@Getter
@Setter
public class ReturnData {
	 private Object data;
	/** The message */
    private String message;
    /** The statusCode */
    private String statusCode;
}
