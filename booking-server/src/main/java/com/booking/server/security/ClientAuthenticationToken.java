package com.booking.server.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

/**
 * Custom authentication token that stores the client ID in the SecurityContext.
 */
public class ClientAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;
    private final Long clientId;

    public ClientAuthenticationToken(Object principal, Long clientId) {
        super(Collections.emptyList());
        this.principal = principal;
        this.clientId = clientId;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    public Long getClientId() {
        return clientId;
    }
}