package com.itheima.springbootquickstart.pojo;

import java.io.Serializable;

//创建学生实体类
public class Student implements Serializable {
    private static final long serialVersionUID = 516271018L;
    private String id;
    private String username;
    private Integer age;
    private Integer gender;
    private String password;


    public Student() {
    }

    public Student(String id, String username, Integer age, Integer gender, String password) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.password = password;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Student{id = " + id + ", username = " + username + ", age = " + age + ", gender = " + gender + ", password = " + password + "}";
    }
}
