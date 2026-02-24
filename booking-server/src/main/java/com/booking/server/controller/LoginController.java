package com.booking.server.controller;

import com.booking.commons.dto.LoginRequest;
import com.booking.commons.entity.User;
import com.booking.commons.service.UserService;
import com.booking.server.security.ClientAuthenticationToken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * REST Controller for user login.
 * Authenticates users, sets clientId in SecurityContext, and creates JSESSIONID.
 * Uses SecurityContextRepository to persist authentication in HttpSession.
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    private final SecurityContextRepository securityContextRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request, 
                                       HttpServletRequest httpRequest,
                                       HttpServletResponse httpResponse) {
        Optional<User> userOpt = userService.getByPhone(request.getPhone());
        
        if (userOpt.isEmpty()) {
            throw new BadCredentialsException("Invalid phone or password");
        }
        
        User user = userOpt.get();
        
        if (!user.getPassword().equals(request.getPassword())) {
            throw new BadCredentialsException("Invalid phone or password");
        }
        
        // Create authentication token with clientId
        ClientAuthenticationToken authentication = 
            new ClientAuthenticationToken(user.getPhone(), user.getClientId());
        
        // Set authentication in SecurityContextHolder
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(authentication);
        SecurityContextHolder.setContext(securityContext);
        
        // Create HttpSession to generate JSESSIONID cookie
        HttpSession session = httpRequest.getSession(true);
        
        // Persist the security context in the session using SecurityContextRepository
        securityContextRepository.saveContext(securityContext, httpRequest, httpResponse);
        
        return ResponseEntity.ok("Login successful");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        // Clear SecurityContext
        SecurityContextHolder.clearContext();
        
        // Save empty context to session to clear authentication
        securityContextRepository.saveContext(SecurityContextHolder.createEmptyContext(), httpRequest, httpResponse);
        
        // Invalidate session to clear JSESSIONID
        HttpSession session = httpRequest.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        
        return ResponseEntity.ok("Logout successful");
    }
}