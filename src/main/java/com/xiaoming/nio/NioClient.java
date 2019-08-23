package com.xiaoming.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.*;

public class NioClient implements Runnable {
    private static Selector selector;
    private static SocketChannel socketChannel;
    private static long Timeout = 2000;
    private volatile static List<SocketChannel> list;

    public NioClient() {
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            selector = Selector.open();
            if (socketChannel.connect(new InetSocketAddress("127.0.0.1",9000))) {
                socketChannel.register(selector, SelectionKey.OP_READ);
            } else {
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
            }
            list = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
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
                            list.add(socketChannel);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        }
                        if (selectionKey.isConnectable()) {
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            if (socketChannel.finishConnect()) {
                                socketChannel.register(selector, SelectionKey.OP_READ);
                                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                byteBuffer.put("你好".getBytes());
                                byteBuffer.flip();
                                socketChannel.write(byteBuffer);
                            } else {
                                System.err.println("可以尝试重试");
                            }
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
                                    byte[] dst=new byte[1024];
                                    buffer.get(dst,0,count);
                                    str1 += new String(dst);
                                }
                            }
                            while (count > 0);
                            ByteBuffer buffer1 = ByteBuffer.wrap(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()).getBytes());
                            System.out.println(str1);
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
        new Thread(new NioClient()).start();
        while (true){
            Scanner scanner=new Scanner(System.in);
            System.out.print("请输入要发送的消息：");
            while (true){
                String s = scanner.nextLine();
                if(s.trim().equals("by")){
                    break;
                }
                try {
                    socketChannel.write(ByteBuffer.wrap(s.getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
