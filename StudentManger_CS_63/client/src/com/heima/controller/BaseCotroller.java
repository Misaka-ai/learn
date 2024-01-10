package com.heima.controller;

import java.util.Scanner;

interface BaseCotroller<T> {

    //学生菜单
    void Start();


    //删除学生
    void delete();


    //修改学生
    void updata();

    //获取id
    String getString(String x);

    //查看学生
    void seeAll();

    //添加学生
    void add();

    T inpuInfo(Scanner sc, String id);

}
