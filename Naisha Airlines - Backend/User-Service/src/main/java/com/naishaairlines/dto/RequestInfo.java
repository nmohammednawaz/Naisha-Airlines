package com.naishaairlines.dto;

import com.naishaairlines.model.NaishaAirlineUser;
import lombok.Data;

@Data
public class RequestInfo {

    private String requestId;
    private String userId;
    private long timestamp;
    private NaishaAirlineUser userInfo;

}
