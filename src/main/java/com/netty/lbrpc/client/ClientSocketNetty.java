package com.netty.lbrpc.client;

import com.netty.lbrpc.service.TestService;

public class ClientSocketNetty {
    public static void main(String[] args) {
        TestService o2=(TestService)ClientRPCProxy.create(TestService.class);
        System.out.println(o2.listAll());
    }
}
