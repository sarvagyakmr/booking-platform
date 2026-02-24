package com.booking.commons.service.dto;

import com.booking.commons.dto.ClientRequest;
import com.booking.commons.dto.ClientResponse;
import com.booking.commons.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * DTO service for Client - mirrors ClientService methods with Request/Response conversion.
 * Uses FQ entity name to avoid ambiguity with @Service.
 */
@Service
@RequiredArgsConstructor
public class ClientDtoService {

    private final ClientService clientService;

    private com.booking.commons.entity.Client toEntity(ClientRequest request) {
        if (request == null) return null;
        com.booking.commons.entity.Client client = new com.booking.commons.entity.Client();
        client.setName(request.getName());
        client.setPhone(request.getPhone());
        return client;
    }

    public ClientResponse create(ClientRequest request) {
        com.booking.commons.entity.Client entity = toEntity(request);
        com.booking.commons.entity.Client saved = clientService.create(entity);
        return ClientResponse.fromEntity(saved);
    }

    public Optional<ClientResponse> getById(Long id) {
        return clientService.getById(id)
                .map(ClientResponse::fromEntity);
    }
}
