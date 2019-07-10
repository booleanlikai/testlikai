package file;

import java.util.concurrent.BlockingQueue;

public abstract class ReadHandleAbstract<T> implements ReadHandle<T> {

    private BlockingQueue<String> blockingQueue;

    private Integer WriteThreadCount;

    public ReadHandleAbstract(BlockingQueue<String> blockingQueue, Integer writeThreadCount) {
        this.blockingQueue = blockingQueue;
        WriteThreadCount = writeThreadCount;
    }

    public BlockingQueue<String> getBlockingQueue() {
        return blockingQueue;
    }

    public void setBlockingQueue(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public Integer getWriteThreadCount() {
        return WriteThreadCount;
    }

    public void setWriteThreadCount(Integer writeThreadCount) {
        WriteThreadCount = writeThreadCount;
    }
}
