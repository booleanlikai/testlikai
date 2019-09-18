package com.netty.lbrpc.service.Impl;

import com.netty.lbrpc.service.TestService;

import java.util.ArrayList;
import java.util.List;

public class TestServiceImpl implements TestService {
    static ArrayList<String> list = new ArrayList<>();

    static {
        list.add("张三");
        list.add("李四");
    }

    @Override
    public List<String> listAll() {
        return list;
    }

    @Override
    public String listBy(Integer id) {
        return list.get(id);
    }

}
