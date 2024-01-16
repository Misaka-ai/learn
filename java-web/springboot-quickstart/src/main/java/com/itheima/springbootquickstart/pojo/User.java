package com.itheima.springbootquickstart.pojo;

import java.util.List;

public class User {
    private String username;
    private String password;
    private int gender;
    private int age;
    private List<String> hobby;
    private List<Pc> pc;

    public List<Pc> getPc() {
        return pc;
    }

    public void setPc(List<Pc> pc) {
        this.pc = pc;
    }

    public User() {
    }

    public User(String username, String password, int gender, int age, List<String> hobby) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.hobby = hobby;
    }

    /**
     * 获取
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     *
     * @return gender
     */
    public int getGender() {
        return gender;
    }

    /**
     * 设置
     *
     * @param gender
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     *
     * @return hobby
     */
    public List<String> getHobby() {
        return hobby;
    }

    /**
     * 设置
     *
     * @param hobby
     */
    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", hobby=" + hobby +
                ", pc=" + pc +
                '}';
    }
}
