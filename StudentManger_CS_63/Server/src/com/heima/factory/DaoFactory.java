package com.heima.factory;

import com.heima.dao.BaseDao;
import java.io.FileReader;
import java.util.Properties;

public class DaoFactory {
    public static BaseDao getDao() {
        //1.读取配置文件
        Properties prop = new Properties();
        try {
            FileReader fr = new FileReader("F:\\Code\\homework\\StudentManger_CS_63\\Server\\application.properties");
            prop.load(fr);
            fr.close();
            String className = prop.getProperty("className");
            //利用反射
            Class<?> calzz = Class.forName(className);
            BaseDao dao = (BaseDao) calzz.newInstance();
            return dao;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
