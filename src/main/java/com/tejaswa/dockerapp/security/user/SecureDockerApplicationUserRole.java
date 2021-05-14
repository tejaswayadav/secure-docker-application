package com.tejaswa.dockerapp.security.user;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.tejaswa.dockerapp.security.user.SecureDockerApplicationUserPermission.*;

public enum SecureDockerApplicationUserRole {
    STUDENT(Sets.newHashSet(STUDENT_READ)),
    TEACHER(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, TEACHER_READ)),
    ADMIN(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, TEACHER_READ, TEACHER_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(STUDENT_READ, TEACHER_READ));

    private final Set<SecureDockerApplicationUserPermission> permissions;

    SecureDockerApplicationUserRole(Set<SecureDockerApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<SecureDockerApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
