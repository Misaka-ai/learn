package com.heima.service;

import com.heima.dao.BaseDao;
import com.heima.domian.Student;
import com.heima.factory.DaoFactory;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Service implements Runnable {
    private Socket socket;

    public Service(Socket socket) {
        this.socket = socket;
    }

    private static BaseDao dao = DaoFactory.getDao();

    @Override
    public void run() {
        //获取数据
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = br.readLine();
            System.out.println("检测到用户报文：" + s);
            //将获得报文进行解析
            String[] strs = s.split("&");
            String option = strs[0];
            String data = strs[1];

            //根据约定好的协议进行相关功能的执行
            switch (option) {
                case "1":
                    add(data);
                    break;
                case "2":
                    seeAll();
                    break;
                case "3":
                    updata(data);
                    break;
                case "5":
                    //判断Id是否存在
                    isExists(data);
                    break;
                case "4":
                    delete(data);
                    break;
            }
            /*switch (option) {
                case "1":
                    add(data);
                    break;
                case "2":
                    seeAll();
                    break;
                case "3":
                    updata(data);
                    break;
                case "5":
                    //判断Id是否存在
                    isExists(data);
                    break;
                case "4":
                    delete(data);
                    break;
            }*/

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //更新学生信息
    private void updata(String data) {
        String[] split = data.split(",");
        Student student = new Student(split[1], split[1], Integer.parseInt(split[2]), split[3]);
        dao.updata(split[0], student);
        try {
            writeMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void writeMessage() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("true");
        bw.newLine();
        bw.flush();
    }

    //判断ID是否存在
    private void isExists(String data) {
        try {
            ArrayList<Student> students = dao.getAll();
            boolean flag = false;
            for (Student stu : students) {
                if (stu.getId().equals(data)) {
                    flag = true;
                }
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(String.valueOf(flag));
            bw.newLine();
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除学生
    private void delete(String data) {
        dao.delete(data);
    }

    //查看学生
    private void seeAll() throws IOException {
        ArrayList<Student> students = dao.getAll();
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(students);
        oos.flush();
    }

    //添加学生
    private void add(String data) throws IOException {
        String[] split = data.split(",");
        Student student = new Student(split[0], split[1], Integer.parseInt(split[2]), split[3]);
        //调用dao添加学生
        dao.add(student);
        writeMessage();

    }


}
