package com.naishaairlines.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomException {

    @NotBlank(message = "Message is required")
    private String message;

    @NotBlank(message = "Description is required")
    private String description;

    @PastOrPresent(message = "Timestamp must be in the past or present")
    private LocalDateTime timeStamp;

    @NotBlank(message = "ErrorCode is required")
    private Integer errorCode;

}
