package com.netty.lbrpc.service;

import java.util.List;

public interface TestService {
    List<String> listAll();

    String listBy(Integer id);
}
