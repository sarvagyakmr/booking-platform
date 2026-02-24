package com.booking.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO for Client.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    private String name;
    private String phone;
}
