package com.itheima.springbootquickstart.dao.impl;

import com.itheima.springbootquickstart.dao.EmpDao;
import com.itheima.springbootquickstart.pojo.Emp;
import com.itheima.springbootquickstart.utils.XmlParserUtils;

import java.util.List;
import java.util.Objects;


public class EmpDaoImpl implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file = Objects.requireNonNull(this.getClass().getClassLoader().getResource("emp.xml")).getFile();
        List<Emp> empList= XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
