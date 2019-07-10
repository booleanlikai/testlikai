package file;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class ReaderAndWrite<T> {
    private String DEF_CHARSET = "UTF-8";
    private Integer WriteThread = 200;
    private Integer ReadThread = 50;
    private Integer BLOCK_COUNT = 600;
    private static Integer INITAL_COUNT = 0;
    private Integer BufferSize = 1024 * 1024;
    private WriteHandle writeHandle;
    private ReadHandle readHandle;
    private buildConsumerThread<T> buildConsumerThread;


    private static volatile BlockingQueue<String> blockingQueue;
    private static AtomicLong readcount = new AtomicLong(INITAL_COUNT);
    private static AtomicLong writecount = new AtomicLong(INITAL_COUNT);

    public ReaderAndWrite() {
        this.blockingQueue = new ArrayBlockingQueue<String>(this.BLOCK_COUNT);
        this.writeHandle = new WriteHandleImp(this.writecount);
        this.readHandle = new ReadHandleImp(this.blockingQueue, this.WriteThread);
        this.buildConsumerThread = new buildConsumerThread<T>(this.WriteThread, this.blockingQueue, this.writeHandle);
    }


    public void createReadThread() {
        BigFileReader.Builder builder = new BigFileReader.Builder("C:/Users/likai/Desktop/testfilein/xiaoming.txt", readHandle, readcount);
        builder.withTreahdSize(this.ReadThread)
                .withCharset(this.DEF_CHARSET)
                .withBufferSize(this.BufferSize);
        BigFileReader bigFileReader = builder.build();
        bigFileReader.start();
    }

    public void createWriteThread() {
        buildConsumerThread buildConsumerThread = new buildConsumerThread(WriteThread, blockingQueue, writeHandle);
        buildConsumerThread.start();
    }

    public void start() {
        long start = new Date().getTime();
        createReadThread();
        createWriteThread();
        long end = new Date().getTime();
        System.out.println(start);
        System.out.println(end);
        System.out.println("消耗时间：" + (end - start));
    }


}
