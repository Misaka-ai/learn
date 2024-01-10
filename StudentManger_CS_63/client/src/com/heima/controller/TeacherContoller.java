/*
package com.heima.controller;


import com.heima.domian.Teacher;

import java.util.Scanner;

public class TeacherContoller implements BaseCotroller{
    private Scanner sc = new Scanner(System.in);



    public void Start() {
        while (true) {
            System.out.println("欢迎来到学生管理界面");
            System.out.println("请选择：");
            System.out.println("1、添加教师  2、查看教师  3、修改教师  4、删除教师 5、退出");
            String command = sc.next();
            switch (command) {
                case "1":
                    //添加教师
                    add();
                    break;
                case "2":
                    //查看教师
                    seeAll();
                    break;
                case "3":
                    //修改教师
                    updata();
                    break;
                case "4":
                    //删除教师
                    delete();
                    break;
                case "5":
                    System.out.println("退出");
                   return;
            }
        }
    }

    //删除老师
    public void delete() {
        String delId = getString("要删除的");
      ts.delete(delId);
    }


    //更新老师
    public void updata() {
        String id = getString("要修改的");
        Teacher teacher = inpuInfo(sc, id);
        ts.updata(id, teacher);
        System.out.println("修改成功");
    }


    //查看老师
    public void seeAll() {
        ArrayList<Teacher> teachers = ts.get();
        if(teachers.isEmpty()){
            System.out.println("无老师可查看");
            return;
        }
        for (Teacher t:teachers){
            System.out.println(t);
        }
    }

    @Override
    public Teacher inpuInfo(Scanner sc, String id) {
        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        System.out.println("请输入生日：");
        String brithday = sc.next();
        return new Teacher(id, name, age, brithday);
    }

    //添加老师
    @Override
    public void add() {
        String id;
        while (true) {
            System.out.println("请输入ID：");
            id = sc.next();
            //判断输入的ID是否重复
            boolean flag = ts.idisExsits(id);
            if (flag) {
                System.out.println("您输入的ID重复！！");
            } else {
                break;
            }
        }
        Teacher teacher = inpuInfo(sc, id);
        ts.add(teacher);
        System.out.println("添加成功！！！");
    }
//判断id是否重复
    @Override
    public String getString(String x) {
        String id;
        while (true) {
            System.out.println("请输入" + x + "ID：");
            id = sc.next();
            //判断输入的ID是否存在

            boolean flag = ts.idisExsits(id);
            if (flag) {
                break;
            } else {
                System.out.println("您输入的ID不存在！！");
            }
        }
        return id;
    }

}
*/
