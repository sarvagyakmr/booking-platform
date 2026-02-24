package com.booking.server.controller;

import com.booking.commons.dto.ClientRequest;
import com.booking.commons.dto.ClientResponse;
import com.booking.commons.service.dto.ClientDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for Client (uses ClientDtoService).
 */
@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController extends AbstractController {

    private final ClientDtoService clientDtoService;

    @PostMapping
    public ResponseEntity<ClientResponse> create(@RequestBody ClientRequest request) {
        return ResponseEntity.ok(clientDtoService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getById(@PathVariable(name = "id") Long id) {
        return clientDtoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
