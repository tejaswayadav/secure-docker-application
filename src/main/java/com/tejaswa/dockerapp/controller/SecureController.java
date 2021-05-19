package com.tejaswa.dockerapp.controller;

import com.tejaswa.dockerapp.model.Student;
import com.tejaswa.dockerapp.model.Teacher;
import com.tejaswa.dockerapp.service.SecureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/v1/secure")
public class SecureController {

    private final SecureService secureService;

    @Autowired
    public SecureController(SecureService secureService) {
        this.secureService = secureService;
    }

    @GetMapping("/")
    public String welcomePage() {
        return "<h1>Welcome to our page</h1>";
    }

    @GetMapping("/contact")
    public String getContactDetails() {
        return "Contact No. : 7828171903";
    }

    @GetMapping("/student/{studentId}")
    @PreAuthorize("hasAuthority('STUDENT')")
    public Student getStudentById(@PathVariable Long studentId) {
        return secureService.getStudentById(studentId);
    }

    @PostMapping("/student/create")
    @PreAuthorize("hasAuthority('STUDENT')")
    public Student createStudent(@RequestBody Student student) {
        return secureService.createStudent(student);
    }

    @DeleteMapping("/student/{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public Boolean deleteStudent(@PathVariable Long studentId) {
        return secureService.deleteStudent(studentId);
    }

    @GetMapping("/teacher/{teacherId}")
    @PreAuthorize("hasAuthority('teacher:read')")
    public Teacher getTeacherById(@PathVariable Long teacherId) {
        return secureService.getTeacherById(teacherId);
    }

    @PostMapping("/teacher/create")
    @PreAuthorize("hasAuthority('teacher:write')")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return secureService.createTeacher(teacher);
    }

    @DeleteMapping("/teacher/{teacherId}")
    @PreAuthorize("hasAuthority('teacher:write')")
    public Boolean deleteTeacher(@PathVariable Long teacherId) {
        return secureService.deleteTeacher(teacherId);
    }

}
