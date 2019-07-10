package file;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class WriteHandleImp extends WriteHandleImpAbstract<String>{



    @Override
    public void handle(String s) throws InterruptedException {
        super.getWriteCount().incrementAndGet();
        System.out.println("消费take:" + s);
        Thread.sleep(10);
    }

    @Override
    public boolean getEnd(String s) {
        if (s.equals("OVER"))
            return true;
        else
            return false;
    }

    public WriteHandleImp(AtomicLong writeCount) {
        super(writeCount);
    }
}
