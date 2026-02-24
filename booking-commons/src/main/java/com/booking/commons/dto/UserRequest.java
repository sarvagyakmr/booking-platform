package com.booking.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO for User.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String phone;
    private String password;
    private Long clientId;  // ID ref - set from request header
}
