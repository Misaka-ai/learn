package com.itheima.springbootquickstart.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeptContorller {
    @RequestMapping("/list")
    public List<Map<String, String>> list() {
        ArrayList<Map<String, String>> list = new ArrayList<>();

        HashMap<String, String> item1 = new HashMap<>();
        item1.put("deptName", "学工部");
        item1.put("updataTime", "2022-07-22 11:23:00");
        HashMap<String, String> item2 = new HashMap<>();
        item2.put("deptName", "校验部");
        item2.put("updataTime", "2022-07-22 11:23:00");
        HashMap<String, String> item3 = new HashMap<>();
        item3.put("deptName", "财务部");
        item3.put("updataTime", "2022-07-22 11:23:00");

        list.add(item1);
        list.add(item2);
        list.add(item3);
        return list;
    }
}
