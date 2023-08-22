package com.naishaairlines.exceptions;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomizedErrorDetails {
	
    @NotBlank(message = "Message is required")
    private String message;
    
    @NotBlank(message = "Description is required")
    private String description;
    
    @PastOrPresent(message = "Timestamp must be in the past or present")
    private LocalDateTime timeStamp;
	
}
