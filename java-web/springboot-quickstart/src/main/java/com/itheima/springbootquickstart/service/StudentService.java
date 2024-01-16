package com.itheima.springbootquickstart.service;

import com.itheima.springbootquickstart.pojo.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

public interface StudentService {
    Student getStudentById(String username);


    boolean signup(Student student);


    boolean deleteStudentById(String id);

    ArrayList<Student> getAllStudent();

    boolean idIsExists(String id);

    Student upadataStudentById(String id, Student student);

    ArrayList<Student> deleteStudentByName(String username);
}
