package com.example.userservice.security;

import com.example.userservice.dao.entities.Role;
import com.example.userservice.dao.entities.User;
import com.example.userservice.dao.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSyncService {

    private final UserRepository userRepository;

    public User syncUserFromJwt(Jwt jwt) {

        String keycloakId = jwt.getSubject();

        return userRepository.findByKeycloakId(keycloakId)
                .orElseGet(() -> {

                    String email = jwt.getClaimAsString("email");
                    String firstName = jwt.getClaimAsString("given_name");
                    String lastName = jwt.getClaimAsString("family_name");

                    // rôle principal (simple règle)
                    Role role = extractRole(jwt);

                    User user = User.builder()
                            .keycloakId(keycloakId)
                            .email(email)
                            .firstName(firstName)
                            .lastName(lastName)
                            .role(role)
                            .createdAt(LocalDateTime.now())
                            .build();

                    return userRepository.save(user);
                });
    }

    private Role extractRole(Jwt jwt) {
        var realmAccess = jwt.getClaim("realm_access");

        if (realmAccess instanceof java.util.Map<?, ?> map) {
            Object rolesObj = map.get("roles");
            if (rolesObj instanceof List<?> roles) {
                if (roles.contains("ADMIN")) return Role.ADMIN;
                if (roles.contains("INSTRUCTOR")) return Role.INSTRUCTOR;
                return Role.STUDENT;
            }
        }
        return Role.STUDENT;
    }
}
