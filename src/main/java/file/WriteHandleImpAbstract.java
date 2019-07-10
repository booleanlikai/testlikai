package file;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public abstract class WriteHandleImpAbstract<T> implements WriteHandle<T> {
    private AtomicLong writeCount;

    public WriteHandleImpAbstract(AtomicLong writeCount) {
        this.writeCount = writeCount;
    }

    public AtomicLong getWriteCount() {
        return writeCount;
    }

    public void setWriteCount(AtomicLong writeCount) {
        this.writeCount = writeCount;
    }
}
