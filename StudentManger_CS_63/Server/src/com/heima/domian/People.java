package com.heima.domian;

import java.io.Serializable;

public class People implements Serializable {
    private static final long serialVersionUID = -1;
    private String id;
    private String name;
    private int age;
    private String brithday;

    public People() {
    }

    public People(String id, String name, int age, String brithday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.brithday = brithday;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return brithday
     */
    public String getBrithday() {
        return brithday;
    }

    /**
     * 设置
     * @param brithday
     */
    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String toString() {
        return id + "," + name + "," + age + "," + brithday;
    }
}
