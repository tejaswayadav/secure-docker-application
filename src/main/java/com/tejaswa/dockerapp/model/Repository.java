package com.tejaswa.dockerapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {

    public static List<Student> STUDENT_LIST = new ArrayList<>(Arrays.asList(
            new Student(1L, "Tejaswa Yadav", 26),
            new Student(2L, "Tulika Yadav", 23),
            new Student(3L, "Vaidehi Yadav", 21)
    ));


    public static List<Teacher> TEACHER_LIST = new ArrayList<>(Arrays.asList(
            new Teacher(1L, "Manoj Mishra", 38),
            new Teacher(2L, "Rakesh Dubey", 54),
            new Teacher(3L, "Deepak Shrivastav", 40)
    ));
}
