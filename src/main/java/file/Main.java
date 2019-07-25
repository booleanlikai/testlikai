package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Main {


    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

//        File file = new File("C:\\Users\\likai\\Desktop\\testfilein\\xiaoming.txt");
//        FileOutputStream fos = new FileOutputStream(file);
//        for (int i = 0; i <999999 ; i++) {
//            fos.write(("这是"+i+"行测试数据\n").getBytes());
//        }
//        fos.close();
        ReaderAndWrite readerAndWrite = new ReaderAndWrite();
        readerAndWrite.start();

    }




}
