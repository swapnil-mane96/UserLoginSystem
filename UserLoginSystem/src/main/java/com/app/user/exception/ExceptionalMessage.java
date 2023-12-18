package com.app.user.exception;

import java.time.LocalDateTime;

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
public class ExceptionalMessage {
	private String error;
	private LocalDateTime dateTime;
	private Boolean status;
}
