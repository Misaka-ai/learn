package com.heima;


import com.heima.controller.StudentController;


import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class ClientApplication {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //创建用户等录界面
        System.out.println("------------欢迎来到黑马信息管理系统-=-------------");

        while (true) {
            welcome();
            System.out.println("请选择：");
            System.out.println("1、学生管理  2、教师管理  3、退出");

            String command = sc.next();
            switch (command) {
                case "1":
                    //学生菜单
                    StudentController stc = new StudentController();
                    stc.Start();
                    break;
                case "2":
                    // TeacherContoller tc = new TeacherContoller();
                    // tc.Start();
                    break;
                case "3":
                    System.out.println("退出成功");
                    return;
            }
        }


    }

    private static void welcome() {
        System.out.println("请选择：");
        while (true) {
            System.out.println("1、登录  2、注册  3、退出");
            String s = sc.next();
            switch (s) {
                case "1":
                    boolean flag = isLogin();
                    if (flag) {
                        return;
                    } else {
                        break;
                    }
                case "2":
                    System.out.println("注册");
                    signup();
                    break;
                case "3":
                    System.out.println("退出");
                    System.exit(0);
            }
        }
    }


    private static boolean isLogin() {
        Properties pro = new Properties();
        try {
            FileReader fr = new FileReader("F:\\Code\\homework\\StudentManger_CS_63\\client\\user.properties");
            pro.load(fr);
            fr.close();
            System.out.println(pro);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            System.out.println("请输入的您的用户名：");
            String name = sc.next();
            System.out.println("请输入您的密码");
            String psw = sc.next();
            if (pro.containsKey(name) && pro.getProperty(name).equals(psw)) {
                System.out.println("登录成功");
                return true;
            } else {
                System.out.println("账户或密码不正确！！！");
                return false;
            }
        }
    }


    private static void signup() {
        //提示用户输入用户名：
        System.out.println("请输入用户名：");
        String userNameInput = sc.next();
        Properties pro = new Properties();
        try {
            FileInputStream fis = new FileInputStream("day01\\user.properties");
            pro.load(fis);
            fis.close();
            //开始判断输入的用户名是否存在
            if (pro.containsKey(userNameInput)) {
                //存在提示重复
                System.out.println("该小可爱已经存在！！！！，请重新输入");
            } else {
                System.out.println("请输入密码：");
                String password = sc.next();
                BufferedWriter bw = new BufferedWriter(new FileWriter("day01\\user.properties"));
                bw.write(userNameInput + "=" + password);
                bw.close();
                System.out.println("注册成功！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

