package com.booking.commons.service;

import com.booking.commons.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for Client entity.
 * Methods: create client and get client by ID.
 */
@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public com.booking.commons.entity.Client create(com.booking.commons.entity.Client client) {
        return clientRepository.save(client);
    }

    public Optional<com.booking.commons.entity.Client> getById(Long id) {
        return clientRepository.findById(id);
    }
}
