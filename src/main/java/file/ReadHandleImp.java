package file;

import java.util.concurrent.BlockingQueue;

public class ReadHandleImp extends ReadHandleAbstract<String> {


    public ReadHandleImp(BlockingQueue<String> blockingQueue, Integer writeThreadCount) {
        super(blockingQueue, writeThreadCount);
    }

    /**
     * 处理每一行数据的对象
     * @param line
     */
    @Override
    public void handle(String line) {
        System.out.println("处理数据" + line);
        try {
            super.getBlockingQueue().put(line);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String setEndFlag() throws InterruptedException {
        super.getBlockingQueue().put("OVER");
        return "OVER";
    }

    @Override
    public Integer getWriteThreadCpunt() {
        return super.getWriteThreadCount();
    }


}
