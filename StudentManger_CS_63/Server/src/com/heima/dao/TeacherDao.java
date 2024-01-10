package com.heima.dao;



import com.heima.domian.Teacher;

import java.io.*;
import java.util.ArrayList;

public class TeacherDao implements BaseDao {
    private static final ArrayList<Teacher> teachers = new ArrayList<>();

    static {
        loadinfo6();
    }

    //返回老师集合
    @Override
    public ArrayList<Teacher> getAll() {
        return teachers;
    }

    //添加老师
    @Override
    public void add(Object o) {
        teachers.add((Teacher) o);
    }

    //更新老师
    @Override
    public void updata(String id, Object o) {
        Teacher teacher = (Teacher) o;
        for (Teacher t : teachers) {
            if (t.getId().equals(id)) {
                t.setName(teacher.getName());
                t.setAge(teacher.getAge());
                t.setBrithday(teacher.getBrithday());
            }
        }
    }

    //删除老师
    @Override
    public void delete(String delId) {
        for (Teacher t : teachers) {
            if (t.getId().equals(delId)) {
                teachers.remove(t);
                return;
            }
        }
    }

    //字节输入流
    public void loadinfo1() {
        //创建字节流对象
        try {
            FileInputStream fis = new FileInputStream("day01\\teacher.txt");
            //创建中间变量
            int len;
            byte[] bytes = new byte[1024];
            //循环读写
            while ((len = fis.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                //将获得字符串先按换行进行分割
                for (String string : s.split(System.lineSeparator())) {
                    String[] strs = string.split(",");
                    Teacher teacher = new Teacher(strs[0], strs[1], Integer.parseInt(strs[2]), strs[3]);
                    teachers.add(teacher);
                }
                //关流
                fis.close();

            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    //缓冲子字节输入流
    public static void loadinfo2() {
        //创建字节流对象
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day01\\teacher.txt"));
            //创建中间变量
            int len;
            byte[] bytes = new byte[1024];
            //循环读写
            while ((len = bis.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                //将获得字符串先按换行进行分割
                for (String string : s.split(System.lineSeparator())) {
                    String[] strs = string.split(",");
                    Teacher teacher = new Teacher(strs[0], strs[1], Integer.parseInt(strs[2]), strs[3]);
                    teachers.add(teacher);
                }
                //关流
                bis.close();
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    //字符输入流
    public static void loadinfo3() {
        //创建字节流对象
        try {
            FileReader fr = new FileReader("day01\\teacher.txt");
            //创建中间变量
            int len;
            char[] chars = new char[1024];
            //循环读写
            while ((len = fr.read(chars)) != -1) {
                String s = new String(chars, 0, len);
                //将获得字符串先按换行进行分割
                for (String string : s.split(System.lineSeparator())) {
                    String[] strs = string.split(",");
                    Teacher teacher = new Teacher(strs[0], strs[1], Integer.parseInt(strs[2]), strs[3]);
                    teachers.add(teacher);
                }
                //关流
                fr.close();
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    //字符缓冲输入流
    public static void loadinfo4() {
        //创建字节流对象
        try {
            BufferedReader br = new BufferedReader(new FileReader("day01\\teacher.txt"));
            //创建中间变量
            String line;

            //循环读写
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                Teacher teacher = new Teacher(strs[0], strs[1], Integer.parseInt(strs[2]), strs[3]);
                teachers.add(teacher);
                //关流
                br.close();
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    //转换输入流
    public static void loadinfo5() {
        //创建字节流对象
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(("day01\\teacher.txt"))));
            //创建中间变量
            String line;
            //循环读写
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                Teacher teacher = new Teacher(strs[0], strs[1], Integer.parseInt(strs[2]), strs[3]);
                teachers.add(teacher);
                //关流
                br.close();
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    //序列化流（对象流）
    public static void loadinfo6() {
        //创建字节流对象
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day01\\teacher.txt"));
            //创建中间变量
            ArrayList<Teacher> teachers1 = (ArrayList<Teacher>) ois.readObject();
            //关流
            ois.close();
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    //字节输出流
    public static void write1() {
        //创建输入出流对象
        try {
            FileOutputStream fos = new FileOutputStream("day01\\teacher.txt");
            for (Teacher teacher : teachers) {
                fos.write(teacher.toString().getBytes());
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //缓冲字节输出流
    public static void write2() {
        //创建输入出流对象
        try {
            BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream("day01\\teacher.txt")) ;
            for (Teacher teacher : teachers) {
                bos.write(teacher.toString().getBytes());
            }
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //字符输出流
    public static void write3() {
        //创建输入出流对象
        try {
            FileWriter fw = new FileWriter("day01\\teacher.txt");
            for (Teacher teacher : teachers) {
                fw.write(teacher.toString());
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //缓冲字符输出流
    public static void write4() {
        //创建输入出流对象
        try {
             BufferedWriter bw =new BufferedWriter(new FileWriter("day01\\teacher.txt")) ;
            for (Teacher teacher : teachers) {
                bw.write(teacher.toString());
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //转换输出流
    public static void write5() {
        //创建输入出流对象
        try {
            BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(new FileOutputStream("day01\\teacher.txt")));
            for (Teacher teacher : teachers) {
                bw.write(teacher.toString());
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //序列化流
    public static void write6(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day01\\teacher.txt"));
            oos.writeObject(teachers);
            oos.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}

