package com.tejaswa.dockerapp.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.tejaswa.dockerapp.security.SecureDockerAppUserPermission.*;

public enum SecureDockerAppUserRole {
    STUDENT(Sets.newHashSet(STUDENT_READ)),
    TEACHER(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, TEACHER_READ)),
    ADMIN(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, TEACHER_READ, TEACHER_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(STUDENT_READ, TEACHER_READ));

    private final Set<SecureDockerAppUserPermission> permissions;

    SecureDockerAppUserRole(Set<SecureDockerAppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<SecureDockerAppUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        return permissions;
    }
}
