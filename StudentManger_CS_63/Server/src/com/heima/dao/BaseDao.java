package com.heima.dao;

import java.util.ArrayList;

public interface BaseDao<T> {
    //添加
    void add(T t);

    //获取
    public ArrayList<T> getAll();

    //更新
    void updata(String id, T t);

    //删除
    void delete(String delid);

}
