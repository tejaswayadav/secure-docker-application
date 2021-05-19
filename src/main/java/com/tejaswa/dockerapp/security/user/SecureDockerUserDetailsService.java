package com.tejaswa.dockerapp.security.user;

import com.tejaswa.dockerapp.security.entity.Student;
import com.tejaswa.dockerapp.security.entity.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecureDockerUserDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;

    @Autowired
    public SecureDockerUserDetailsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Student> students = studentRepository.findByEmail(username);
        if (students.size() == 0) {
            throw new UsernameNotFoundException("User not available:" + username);
        }
        return new SecureStudent(students.get(0));
    }
}
