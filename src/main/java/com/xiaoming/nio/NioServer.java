package com.xiaoming.nio;


import org.springframework.expression.spel.ast.Selection;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.*;

public class NioServer {

    private static ServerSocketChannel serverSocketChannel;
    private static Selector selector;
    private static long Timeout = 2000;
    private volatile static List<SocketChannel> list;

    public NioServer() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(9000));
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            list = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void start() {
        while (true) {
            try {
                selector.select(Timeout);
                Set<SelectionKey> selectionkeys = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionkeys.iterator();
                while (selectionKeyIterator.hasNext()) {
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    if (selectionKey.isValid()) {
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            ByteBuffer buffer1 = ByteBuffer.wrap(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()).getBytes());
                            socketChannel.write(buffer1);
                            list.add(socketChannel);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        }
                        if (selectionKey.isReadable()) {
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            String str1 = "";
                            int count = 0;
                            do {
                                buffer.clear();
                                count = socketChannel.read(buffer);
                                buffer.flip();
                                if (count > 0) {
                                    list.stream().filter(n -> n != socketChannel).forEach(n -> {
                                        try {
                                            int write = n.write(buffer);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    });
                                }
                            }
                            while (count > 0);
                        }
                    }
                    selectionKeyIterator.remove();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        NioServer nioServer=new NioServer();
        nioServer.start();
    }
}
