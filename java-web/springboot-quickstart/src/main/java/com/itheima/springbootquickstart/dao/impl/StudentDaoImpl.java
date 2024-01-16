package com.itheima.springbootquickstart.dao.impl;

import com.itheima.springbootquickstart.dao.StudentDao;
import com.itheima.springbootquickstart.pojo.Student;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
@Repository
public class StudentDaoImpl implements StudentDao {
    private static ArrayList<Student> students;

    static {
        loadAllStudent();
        System.out.println(students);
    }


    @Override
    public ArrayList<Student> getAllStudentds() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
        saveStudent();
    }

    //删除学生
    @Override
    public void deleteStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(id);
            }
        }
        saveStudent();
    }

    //根据ID修该
    @Override
    public Student upadataStudentById(String id, Student student) {

        for (Student student1 : students) {
            if (student1.getId().equals(id)) {
                student1.setUsername(student.getUsername());
                student1.setAge(student.getAge());
                student1.setGender(student.getGender());
                student1.setPassword(student.getPassword());
                saveStudent();
                return student1;
            }
        }

        return new Student();
    }

    @Override
    public ArrayList<Student> deleteStudentByName(String username) {
        students.removeIf(student -> student.getUsername().equals(username));
        saveStudent();
        return students;
    }

    //创建序列化流
    public void saveStudent() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\Project_63\\java-web\\springboot-quickstart\\src\\main\\java\\com\\itheima\\springbootquickstart\\dao\\student.txt"));) {
            oos.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //创建反序列化流
    public static void loadAllStudent() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\Project_63\\java-web\\springboot-quickstart\\src\\main\\java\\com\\itheima\\springbootquickstart\\dao\\student.txt"));) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (Exception e) {

        }

    }


}
