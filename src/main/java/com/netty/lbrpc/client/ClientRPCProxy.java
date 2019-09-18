package com.netty.lbrpc.client;


import com.netty.lbrpc.entity.ClassInfo;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ClientRPCProxy {
    public static Object create(Class clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                ClassInfo classInfo = new ClassInfo();
                classInfo.setClassName(clazz.getName());
                classInfo.setMethodName(method.getName());
                classInfo.setArgs(args);
                classInfo.setClazzType(method.getParameterTypes());

                EventLoopGroup eventExecutors = new NioEventLoopGroup();
                Bootstrap bootstrap = new Bootstrap();
                ClientSocketNettyHandler socketNettyHandler = new ClientSocketNettyHandler();
                bootstrap.group(eventExecutors)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                ChannelPipeline channelPipeline = socketChannel.pipeline();
                                channelPipeline.addLast("encoder", new ObjectEncoder());
                                channelPipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                                channelPipeline.addLast(socketNettyHandler);
                            }
                        });
                System.out.println("........client init......");
                ChannelFuture future = bootstrap.connect("127.0.0.1", 9090).sync();
                future.channel().writeAndFlush(classInfo).sync();
                future.channel().closeFuture().sync();
                return socketNettyHandler.getResponse();
            }
        });
    }
}
