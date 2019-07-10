package file;

import java.util.concurrent.BlockingQueue;


public class Consumer<T> implements Runnable {
    private WriteHandle writeHandle;
    private BlockingQueue<T> blockingQueue;

    public Consumer(BlockingQueue<T> blockingQueue, WriteHandle writeHandle) {
        this.blockingQueue = blockingQueue;
        this.writeHandle = writeHandle;
    }

    @Override
    public void run() {
        while (true) {
            try {
                T readlin = blockingQueue.take();
                if (writeHandle.getEnd(readlin))
                    break;
                writeHandle.handle(readlin);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
