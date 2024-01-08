package com.heima.controller;


import com.heima.constant.Operator;
import com.heima.domian.Student;
import com.heima.utils.AgeUtils;

import java.io.*;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController implements BaseCotroller {
    private final Scanner sc = new Scanner(System.in);

    //学生菜单
    @Override
    public void Start() {
        while (true) {
            System.out.println("欢迎来到学生管理界面");
            System.out.println("请选择：");
            System.out.println("1、添加学生  2、查看学生  3、修改学生  4、删除学生  5、退出");
            String command = sc.next();
            switch (command) {
                case Operator.ADD_STDUENT:
                    //添加学生
                    add();
                    break;
                case Operator.LOOKALL_STUDENT:
                    //查看学生
                    seeAll();
                    break;
                case Operator.UPDATA_STUDENT:
                    //修改学生
                    updata();
                    break;
                case Operator.DELETE_STUDENT:
                    //删除学生
                    delete();
                    break;
                case Operator.EXIT:
                    System.out.println("退出");
                    return;
            }
        }
    }

    //删除学生
    @Override
    public void delete() {
        if (getArr()) {
            System.out.println("无数据可删除");
            return;
        }
        String s = getString("要删除的");
        try (Socket socket = getSocket()) {
            writeMessage(socket, "4&" + s);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    //修改学生
    @Override
    public void updata() {
        if (getArr()) {
            System.out.println("无数据可修改");
            return;
        }
        String id = getString("要修改的");
        Student student = (Student) inpuInfo(sc, id);
        try (Socket socket = getSocket()) {
            //创建字符缓冲输入流将学生对象写到server中
            writeMessage(socket, "3&" + student);
            //接收服务端返回的信息
            String s = readMessage(socket);
            System.out.println(Boolean.parseBoolean(s) ? "修改成功" : "修改失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取id
    @Override
    public String getString(String x) {
        String id = null;
        while (true) {
            System.out.println("请输入" + x + "ID：(输入end退出)");
            id = sc.next();
            if (id.equals("end")) {
                break;
            } else {
                try (Socket socket = getSocket();) {
                    writeMessage(socket, "5&" + id);
                    //接收传输回来的数据
                    String s = readMessage(socket);
                    if (Boolean.parseBoolean(s)) {
                        break;
                    } else {
                        System.out.println("输入的ID不存在！！！，请重新输入！");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return id;
    }

    //查看学生
    @Override
    public void seeAll() {
        if (getArr()) {
            System.out.println("无数据可查看");
            return;
        }
        try (Socket socket = getSocket()) {
            writeMessage(socket, "2&nn");
            //接收服务端传回的数据
            ArrayList<Student> stus = (ArrayList<Student>) new ObjectInputStream(socket.getInputStream()).readObject();
            stus.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean getArr() {
        try (Socket socket = getSocket()) {
            writeMessage(socket, "2&nn");
            //接收服务端传回的数据
            ArrayList<Student> stus = (ArrayList<Student>) new ObjectInputStream(socket.getInputStream()).readObject();
            return stus.isEmpty();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //添加学生
    @Override
    public void add() {
        try {
            while (true) {
                System.out.println("请输入ID：");
                String id = sc.next();
                try (Socket socket = getSocket()) {
                    Student student = inpuInfo(sc, id);
                    //判断ID是否存在
                    writeMessage(socket, "5&" + id);
                    //接收服务端返回的信息
                    String s1 = readMessage(socket);
                    if (Boolean.parseBoolean(s1)) {
                        System.out.println("ID重复！！！");
                    } else {
                        try (Socket socket1 = getSocket();) {
                            //创建字符缓冲输入流将学生对象写到server中
                            writeMessage(socket1, "1&" + student);
                            //接收服务端返回的信息
                            String s = readMessage(socket1);
                            System.out.println(Boolean.parseBoolean(s) ? "添加成功" : "添加失败");
                        }
                    }
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readMessage(Socket socket) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return br1.readLine();

    }

    private static void writeMessage(Socket socket, String id) throws IOException {
        BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw1.write(id);
        bw1.newLine();
        bw1.flush();
    }

    //返回Socket对象
    private Socket getSocket() {
        try {
            return new Socket("127.0.0.1", 10086);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //信息录入
    @Override
    public Student inpuInfo(Scanner sc, String id) {
        System.out.println("请输入姓名：");
        String name = sc.next();
        String brithday = null;
        int age1;
        while (true) {
            System.out.println("请输入生日：");
            brithday = sc.next();
            //创建格式化器
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //将输入的的生日转化成日期对象
            try {
                age1 = AgeUtils.getAge(brithday, dtf);
                break;
            } catch (Exception e) {
                System.out.println("您输入的格式不正确！！请重新输入！");
            }
        }
        return new Student(id, name, age1, brithday);
    }


}
