package com.booking.server.controller;

import com.booking.server.security.ClientAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Abstract base controller providing common functionality for all controllers.
 * Includes utility methods for extracting client ID from SecurityContextHolder.
 */
public abstract class AbstractController {

    /**
     * Extracts the client ID from the SecurityContextHolder.
     * Retrieves the ClientAuthenticationToken from the current authentication.
     *
     * @return the client ID as a Long, or null if not authenticated or clientId not available
     */
    protected Long getClientId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        
        if (authentication instanceof ClientAuthenticationToken) {
            ClientAuthenticationToken token = (ClientAuthenticationToken) authentication;
            return token.getClientId();
        }
        
        return null;
    }
}
