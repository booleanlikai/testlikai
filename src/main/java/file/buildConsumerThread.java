package file;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class buildConsumerThread<T> {

    private Integer threadcount;
    private ExecutorService executorService;
    private WriteHandle writeHandle;
    private BlockingQueue<T> blockingQueue;


    public buildConsumerThread(Integer threadcount, BlockingQueue blockingQueue,WriteHandle writeHandle) {
        this.threadcount = threadcount;
        this.blockingQueue = blockingQueue;
        this.writeHandle=writeHandle;
        this.executorService = Executors.newFixedThreadPool(threadcount);
    }

    public void start(){
        for (int i = 0; i < this.threadcount; i++) {
            Consumer<T> consumer = new Consumer<T>(this.blockingQueue,this.writeHandle);
            this.executorService.execute(consumer);
        }
        this.executorService.shutdown();
    }

}
