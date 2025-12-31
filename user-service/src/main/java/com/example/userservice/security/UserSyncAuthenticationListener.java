package com.example.userservice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;

@Component
@RequiredArgsConstructor
public class UserSyncAuthenticationListener {

    private final UserSyncService userSyncService;

    @EventListener
    public void onAuthentication(AbstractAuthenticationEvent event) {

        if (event.getAuthentication() instanceof JwtAuthenticationToken jwtAuth) {
            userSyncService.syncUserFromJwt(jwtAuth.getToken());
        }
    }
}
