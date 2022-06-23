package com.portfolioweb.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String status;
    
    private String code;
    
    private String message;
}
