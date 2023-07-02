package ru.kata.spring.boot_security.demo.configs;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Collection;
import java.util.Set;


@Component
public class UserSecurity {
    private final UserService userService;

    public UserSecurity(UserService userService) {
        this.userService = userService;
    }

    public boolean checkUsernameById(Authentication authentication, Long id) {
        return userService.findIdByUsername(authentication.getName()).equals(id);
    }

    public boolean checkAdminRole(Authentication authentication) {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        return roles.contains("ROLE_ADMIN");
    }
    public Long getId(Authentication authentication) {
        return userService.findIdByUsername(authentication.getName());
    }
}
