package file;

public interface WriteHandle<T> {

    /**
     * 处理每条数据
     *
     * @param t
     * @throws InterruptedException
     */
    public void handle(T t) throws InterruptedException;

    /**
     * 判断结束标志符
     *
     * @param t
     * @return
     */
    public boolean getEnd(T t);
}
