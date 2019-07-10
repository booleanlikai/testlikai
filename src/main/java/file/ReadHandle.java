package file;

public interface ReadHandle<T> {

    public void handle(String t);

    public T setEndFlag() throws InterruptedException;

    public Integer getWriteThreadCpunt();

}
