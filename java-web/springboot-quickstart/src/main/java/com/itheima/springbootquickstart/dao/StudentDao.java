package com.itheima.springbootquickstart.dao;

import com.itheima.springbootquickstart.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentDao {
    ArrayList<Student> getAllStudentds();

    void addStudent(Student student);

    void deleteStudentById(String id);

    Student upadataStudentById(String id, Student student);

    ArrayList<Student> deleteStudentByName(String username);

    ArrayList<Student> deletestudentByNmmes(List<String> usernames);
}
