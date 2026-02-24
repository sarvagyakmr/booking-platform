package com.booking.commons.dto;

import com.booking.commons.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Response DTO for Client with mapper.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private Long id;
    private String name;
    private String phone;
    private Long version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ClientResponse fromEntity(Client client) {
        if (client == null) return null;
        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getPhone(),
                client.getVersion(),
                client.getCreatedAt(),
                client.getUpdatedAt()
        );
    }
}
