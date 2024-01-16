package com.itheima.springbootquickstart.controller;


import com.itheima.springbootquickstart.pojo.Emp;
import com.itheima.springbootquickstart.service.EmpService;

import com.itheima.springbootquickstart.utils.Result;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
   /* //自动注入
    @Autowired
    //根据名称注入
    @Qualifier("empServiceImpl")*/
    @Resource(name = "empServiceImpl")
    private EmpService empService;
    @GetMapping("/listEmp")
    public Result listEmp() {
        List<Emp> empList = empService.listEmp();
        //3. 响应数据
        return Result.success(empList);
    }

}

