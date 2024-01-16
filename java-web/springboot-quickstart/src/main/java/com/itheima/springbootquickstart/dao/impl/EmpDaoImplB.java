package com.itheima.springbootquickstart.dao.impl;

import com.itheima.springbootquickstart.dao.EmpDao;
import com.itheima.springbootquickstart.pojo.Emp;
import com.itheima.springbootquickstart.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public class EmpDaoImplB implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList= XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
