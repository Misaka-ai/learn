package com.itheima.springbootquickstart.requestcontroller;

import com.itheima.springbootquickstart.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class RequestController {
    //请求相应的的两个对象

    @RequestMapping("/simpleParam")
    public String simpleParam(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "OK";
    }

    @RequestMapping("/orginal")
    public String orginal(HttpServletRequest httpServletRequest) {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "OK";
    }

    //
    @RequestMapping("/simple")
    public String simple(@RequestParam String username, @RequestParam(name = "pwd", required = false, defaultValue = "8888888") String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "OK";
    }

    //map集合传参需要添加@RequestParam注解
    @RequestMapping("/simple1")
    public String simple(@RequestParam Map<String, String> parmas) {
        String username = parmas.get("username");
        String password = parmas.get("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "simple1";
    }

    //对象
    @RequestMapping("/simple2")
    public String simple2(User user) {
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        return "simple2";
    }

    //数组
    @RequestMapping("/simple3")
    public String simple3(String[] hobby) {
        System.out.println("hobby = " + Arrays.toString(hobby));
        return "simple3";
    }

    //集合
    @RequestMapping("/simple4")
    public String simple4(@RequestParam List<String> hobby) {
        System.out.println("list = " + hobby);
        return "simple4";
    }

    //localDateTime
    @RequestMapping("/time")
    public String time(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime birthday) {
        System.out.println("birthday = " + birthday);
        return "time";
    }

    //请求体
//  直接用字符串接收
    @PostMapping("/bodyparam")
    public String bodyparam(@RequestBody String json) {
        System.out.println("json = " + json);
        return "bodyparam";
    }

    //用map集合接收
    @RequestMapping("/bodyparam1")
    public String bodyparam1(@RequestBody Map<String, Object> params) {
        System.out.println("params = " + params);
        return "bodyparam1";
    }

    @RequestMapping("/bodyparam2")
    public String bodyparam2(@RequestBody User user) {
        System.out.println("user = " + user);
        return "bodyparam2";
    }

    //有多个类，可以用集合装，也可以直接创建一个类来
    @RequestMapping("/bodyparam3")
    public String bodyparam3(@RequestBody User user) {
        System.out.println("user = " + user);
        return "bodyparam3";
    }

    //    路径参数
    @RequestMapping("/pathparam/{id}/{age}")
    public String bodyparam4(@PathVariable Integer id, @PathVariable Integer age) {
        System.out.println("id = " + id);
        System.out.println("age = " + age);
        return "pathparam";
    }

}

