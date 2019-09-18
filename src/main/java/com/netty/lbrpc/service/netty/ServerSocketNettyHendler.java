package com.netty.lbrpc.service.netty;

import com.netty.lbrpc.entity.ClassInfo;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ChannelHandler.Sharable
public class ServerSocketNettyHendler extends ChannelInboundHandlerAdapter {

    public static ServerSocketNettyHendler serverSocketNettyHendler = new ServerSocketNettyHendler();
    private static ExecutorService executorService = Executors.newFixedThreadPool(1000);

    public String getImplClassName(ClassInfo classInfo) throws ClassNotFoundException {
        String iName = "com.netty.lbrpc.service";
        int i = classInfo.getClassName().lastIndexOf(".");
        String className = classInfo.getClassName().substring(i);
        Class aclass = Class.forName(iName + className);
        Reflections reflections = new Reflections(iName);
        Set<Class<?>> classes = reflections.getSubTypesOf(aclass);
        if (classes.size() == 0) {
            System.out.println("未找到实现类");
            return null;
        } else if (classes.size() > 1) {
            System.out.println("找到多个实现类，未明确使用那个实现类 ");
            return null;
        } else {
            Class[] classes1 = classes.toArray(new Class[0]);
            return classes1[0].getName();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        executorService.execute(() -> {
            ClassInfo classInfo = (ClassInfo) msg;
            try {
                Object o = Class.forName(getImplClassName(classInfo)).newInstance();
                Method method = o.getClass().getMethod(classInfo.getMethodName(), classInfo.getClazzType());
                Object invoke = method.invoke(o, classInfo.getArgs());
                ctx.writeAndFlush(invoke);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}
