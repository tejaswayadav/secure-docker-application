package com.tejaswa.dockerapp.service;

import com.tejaswa.dockerapp.model.Student;
import com.tejaswa.dockerapp.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.tejaswa.dockerapp.model.Repository.STUDENT_LIST;
import static com.tejaswa.dockerapp.model.Repository.TEACHER_LIST;

@Service
public class SecureService {
    public Student getStudentById(Long studentId) {
        Optional<Student> optionalStudent = STUDENT_LIST.stream()
                .filter(student -> student.getId().equals(studentId))
                .findFirst();

        return optionalStudent.orElse(null);
    }

    public Teacher getTeacherById(Long teacherId) {
        Optional<Teacher> optionalTeacher = TEACHER_LIST.stream()
                .filter(teacher -> teacher.getId().equals(teacherId))
                .findFirst();

        return optionalTeacher.orElse(null);
    }

    public Student createStudent(Student student) {
        STUDENT_LIST.add(student);
        return student;
    }

    public Teacher createTeacher(Teacher teacher) {
        TEACHER_LIST.add(teacher);
        return teacher;
    }

    public Boolean deleteStudent(Long studentId) {
        Optional<Student> optionalStudent = STUDENT_LIST.stream()
                .filter(student -> student.getId().equals(studentId))
                .findFirst();
        if (optionalStudent.isPresent()) {
            STUDENT_LIST.remove(optionalStudent.get());
            return true;
        }
        return false;
    }

    public Boolean deleteTeacher(Long teacherId) {
        Optional<Teacher> optionalTeacher = TEACHER_LIST.stream()
                .filter(teacher -> teacher.getId().equals(teacherId))
                .findFirst();
        if (optionalTeacher.isPresent()) {
            TEACHER_LIST.remove(optionalTeacher.get());
            return true;
        }
        return false;
    }
}
