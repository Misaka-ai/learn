package com.heima.dao;


import com.heima.domian.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;

public class StudentDao implements BaseDao {
    public static final Logger LOGGER = LoggerFactory.getLogger(StudentDao.class);
    //创建静态集合
    static ArrayList<Student> stus = new ArrayList<>();

    static {
        //loadInfo02();
        LOGGER.info("---------------loadStart----------------------");
        loadInfo04();
        LOGGER.info("---------------loadEnd----------------------");
    }

    //字节输出流
    private void write01() {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day01\\students"));) {
            for (Student student : stus) {
                bos.write(student.toString().getBytes());
                bos.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    //字符输出流
    private void write02() {
        try (BufferedWriter bos = new BufferedWriter(new FileWriter("day01\\students"));) {
            for (Student student : stus) {
                bos.write(student.toString());
                bos.write(System.lineSeparator());
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    //转换输出流
    private void write03() {
        try (BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("day01\\students")));) {
            for (Student student : stus) {
                bos.write(student.toString());
                bos.write(System.lineSeparator());
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    //对象流
    private void write04() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\Code\\homework\\StudentManger_CS_63\\Server\\students.txt"));
            oos.writeObject(stus);
            oos.close();
            LOGGER.info("写入成功");
        } catch (IOException e) {
            LOGGER.error("写入失败！！" + e.getMessage());

        }
    }


    //字节输入流
    private static void loadInfo01() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day01\\students"));) {
            int len;
            byte[] bytes = new byte[1024];
            while ((len = bis.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                for (String string : s.split(System.lineSeparator())) {
                    String[] str = string.split(",");
                    Student student = new Student(str[0], str[1], Integer.valueOf(str[2]), str[3]);
                    stus.add(student);
                }

            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    //字符缓冲输入流
    private static void loadInfo02() {
        try (BufferedReader bis = new BufferedReader(new FileReader("day01\\students"));) {
            String line;
            while ((line = bis.readLine()) != null) {
                String[] str = line.split(",");
                Student student = new Student(str[0], str[1], Integer.valueOf(str[2]), str[3]);
                stus.add(student);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    //转换输入流
    private static void loadInfo03() {
        try (BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream("day01\\students")));) {
            String line;
            while ((line = bis.readLine()) != null) {
                String[] str = line.split(",");
                Student student = new Student(str[0], str[1], Integer.valueOf(str[2]), str[3]);
                stus.add(student);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    //对象输入流
    private static void loadInfo04() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\Code\\homework\\StudentManger_CS_63\\Server\\students.txt"));
            stus = (ArrayList<Student>) ois.readObject();
            LOGGER.info("写入集合成功");
        } catch (Exception e) {
            //e.printStackTrace();
            LOGGER.error("初始化失败!!" + e.getMessage());
        }
    }

    //添加学生
    @Override
    public void add(Object o) {
        LOGGER.info("开始添加，方法入参：{}", o.toString());
        stus.add((Student) o);
        //write02();
        write04();
        LOGGER.info("添加成功");
    }

    //获得集合
    @Override
    public ArrayList<Student> getAll() {
        LOGGER.info("开始返回，方法入参：{}", stus.toString());
        return stus;

    }

    //修改学生
    @Override
    public void updata(String id, Object o) {
        LOGGER.info("开始添加，方法入参：{}", id + o.toString());
        Student student = (Student) o;
        for (Student s : stus) {
            if (s.getId().equals(id)) {
                s.setName(student.getName());
                s.setAge(student.getAge());
                s.setBrithday(student.getBrithday());
            }
        }
        // write02();
        write04();
    }

    //删除学生
    @Override
    public void delete(String delid) {
        LOGGER.info("开始删除，方法入参：{}", delid);
        for (Student s : stus) {
            if (s.getId().equals(delid)) {
                stus.remove(s);
                return;
            }
        }
        // write02();
        write04();
        LOGGER.info("删除完成并重新写入完成！");
    }


}
