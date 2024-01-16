package com.itheima.springbootquickstart.service.impl;

import com.itheima.springbootquickstart.dao.StudentDao;

import com.itheima.springbootquickstart.pojo.Student;
import com.itheima.springbootquickstart.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    //返回查询的人
    @Override
    public Student getStudentById(String id) {
        Student stu = new Student();
        ArrayList<Student> allStudentds = studentDao.getAllStudentds();
        for (Student allStudentd : allStudentds) {
            if (allStudentd.getId().equals(id)) {
                stu = allStudentd;
            }
        }
        return stu;
    }

    @Override
    public boolean signup(Student student) {
/*注册一个学生信息，要求填写用户名，年龄，性别，密码，其中密码如果未填写，则默认是123456
1. 用户名不能重复，已经存在的用户返回用户已存在
2. 密码必须在6~16位之前，否则返回密码不符合要求
3. 性别是选填项，可选值为1、2和空
4. 年龄是数字*/
        //判单用户名是否重复
        ArrayList<Student> students = getAllStudentds();
        for (Student student1 : students) {
            if (student1.getId().equals(student.getId())) {
                return true;
            }
        }
        if (student.getPassword().length() < 6 || student.getPassword().length() > 16) {
            return true;
        }
        String regex = "[0-9]+";
        if (!student.getAge().toString().matches(regex)) {
            throw new RuntimeException("年龄只能是数字");
        }
        studentDao.addStudent(student);
        return false;
    }

    //根据该
    @Override
    public boolean deleteStudentById(String id) {
        ArrayList<Student> allStudentds = getAllStudentds();
        for (Student allStudentd : allStudentds) {
            if (allStudentd.getId().equals(id)) {
                studentDao.deleteStudentById(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Student> getAllStudent() {
        return getAllStudentds();
    }

    //判断ID是否存在
    @Override
    public boolean idIsExists(String id) {
        ArrayList<Student> allStudentds = getAllStudentds();
        for (Student allStudentd : allStudentds) {
            if (allStudentd.getId().equals(id)) {
                //返回true表示存在
                return true;
            }
        }
        //都不满足就返回false
        return false;
    }

    //根据ID进行修改
    @Override
    public Student upadataStudentById(String id, Student student) {
        return studentDao.upadataStudentById(id, student);
    }

    //根据名字删除
    @Override
    public ArrayList<Student> deleteStudentByName(String username) {
        return studentDao.deleteStudentByName(username);
    }

    //获得集合中的全部数据
    public ArrayList<Student> getAllStudentds() {
        return studentDao.getAllStudentds();
    }
}
