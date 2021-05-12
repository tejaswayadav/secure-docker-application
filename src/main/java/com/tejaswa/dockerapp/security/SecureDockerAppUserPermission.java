package com.tejaswa.dockerapp.security;

public enum SecureDockerAppUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    TEACHER_READ("teacher:read"),
    TEACHER_WRITE("teacher:write");

    private final String permission;

    SecureDockerAppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
