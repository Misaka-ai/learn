package com.itheima.springbootquickstart.service.impl;

import com.itheima.springbootquickstart.dao.EmpDao;
import com.itheima.springbootquickstart.dao.impl.EmpDaoImpl;
import com.itheima.springbootquickstart.pojo.Emp;
import com.itheima.springbootquickstart.service.EmpService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service//衍生注解
public class EmpServiceImpl implements EmpService {

    private EmpDao empDao=new EmpDaoImpl();
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();

        for (Emp emp : empList) {
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }
        }
        ;
        return empList;

    }
}
