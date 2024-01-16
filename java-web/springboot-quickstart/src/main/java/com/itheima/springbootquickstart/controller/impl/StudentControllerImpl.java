package com.itheima.springbootquickstart.controller.impl;

import com.itheima.springbootquickstart.controller.StudentController;
import com.itheima.springbootquickstart.pojo.Student;
import com.itheima.springbootquickstart.service.StudentService;
import com.itheima.springbootquickstart.service.impl.StudentServiceImpl;
import com.itheima.springbootquickstart.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentControllerImpl implements StudentController {

 //   private StudentService studentService=new StudentServiceImpl();
 private final StudentService studentService;
    @Autowired
    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }
    //注册
    @PostMapping("/application/json")
    public Result listStuent(@RequestBody Student student) {
        System.out.println("student = " + student);
        boolean flag = studentService.signup(student);
        if (flag) {
            return Result.success("id或者密码不符合要求");
        } else {
            return Result.success("注册成功");
        }

    }

    //根据ID查看
    @GetMapping("/users/{id}")
    public Result show(@PathVariable String id) {
        Student student = studentService.getStudentById(id);
        Student student1 = new Student(student.getId(), student.getUsername(), student.getGender(), student.getAge(), "***********");
        return Result.success(student1);
    }

    //根据ID删除
    @DeleteMapping("/users/{id}")
    public Result delete(@PathVariable String id) {
        boolean flag = studentService.deleteStudentById(id);
        if (flag) {
            System.out.println("删除成功！");
        } else {
            System.out.println("无数据可删除！");
        }
        return Result.success(id);
    }

    //查看所有人
    @GetMapping("/users/list")
    public Result seeAll() {
        ArrayList<Student> students = studentService.getAllStudent();
        ArrayList<Student> students1 = new ArrayList<>();
        for (Student student : students) {
            Student student1 = new Student(student.getId(), student.getUsername(), student.getGender(), student.getAge(), "***********");
            students1.add(student1);
        }
        return Result.success(students1);
    }

    //根据ID修改
    @PutMapping("/users/json")
    public Result updataById(@RequestBody Student student) {
        //先判断集合是否为空
        ArrayList<Student> students = studentService.getAllStudent();
        if (students.isEmpty()) {
            return Result.success("无信息可修改");
        }
        String id = student.getId();

        //再判断ID是否存在
        boolean flag = studentService.idIsExists(id);
        if (!flag) {
            return Result.success("输入的ID不存在！！！");
        }
        //若是存在则运行第一个
        Student student1 = studentService.upadataStudentById(id, student);
        Student student2 = new Student(student1.getId(), student1.getUsername(), student1.getGender(), student1.getAge(), "***********");
        return Result.success(student2);
    }

    //删除所有名字一样的
    @DeleteMapping("users/delBatch/{username}")
    public Result deleteByName(@PathVariable String username) {
        ArrayList<Student> students = studentService.deleteStudentByName(username);
        return Result.success("删除后的集合"+students);

    }
}