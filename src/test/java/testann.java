import com.xiaoming.test.*;
import org.junit.Test;
import sun.nio.ch.DirectBuffer;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collector;

public class testann {


    @Test
    public void testannn() throws NoSuchFieldException, IllegalAccessException {
        classA a = new classA();
        classB b = new classB();
        Class aclss = a.getClass();
        Field[] fields = aclss.getDeclaredFields();
        Class bclass = b.getClass();
        a.setAge("age");
        a.setCode("code");
        a.setName("name");
        for (Field f : fields) {
            copya copya = f.getAnnotation(com.xiaoming.test.copya.class);
            System.out.println("...");
            Field field = bclass.getDeclaredField(String.valueOf(copya.name()));
            field.setAccessible(true);
            f.setAccessible(true);
//            String bb=String.valueOf();
            field.set(b, f.get(a));
            System.out.println("sss");


        }


    }

    @Test
    public void testmod() {
        System.out.println(3455 % 10);
        int x1 = 23;
        int x2 = x1 >> 1;
        System.out.println(23 >> 3);
        System.out.println();
        System.out.println("\u2122");

    }

    @Test
    public void testswitch() {
        long x = 11;
        type a = type.BB;
        System.out.println(a.getAa());
        System.out.println(a.getBb());
        a.setAa("ssssss");
        a.setBb("bbbbbb");
        System.out.println(a.getAa());
        System.out.println(a.getBb());
        switch (a) {
            case AA:
                break;
            case BB:
                break;
            case CC:
                break;
            default:
                break;
        }


    }

    @Test
    public void testbreak() {

        readdata:
        while (true) {
            System.out.println("dddddddddddddddddd");
            for (int i = 0; i < 100; i++) {
                if (i == 20) break readdata;
                System.out.println(i);
            }
        }
        label:
        {
            while (true) {
                System.out.println("nnnnnn");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
                System.out.println("aaaaa");
                if (true) break label;
            }
        }

    }


    @Test
    public void test123() {
//静态方法
        IConvert<String, String> convert = Something::startWith;
        String converted = convert.convert("123");
//访问对象方法
        Something something = new Something();
        IConvert<String, String> convert1 = something::endWith;
        String converted1 = convert1.convert("123");
        System.out.println(converted1);
//构造访问方法
        IConvert<String, Something> convert2 = Something::new;
        Something converted2 = convert2.convert("123");
        System.out.println(converted2.toString());


    }

    @Test
    public void testarrstory() {
        Manager[] manager = new Manager[10];
        manager[0] = new Manager();
        Employee[] staff = manager;
        staff[1] = new Employee();
        manager[0].setBonus(122);
    }

    @Test
    public void test() {
        ClassLoader c = testann.class.getClassLoader();
        System.out.println(c);
        ClassLoader c1 = c.getParent();
        System.out.println(c1);
        ClassLoader c2 = c1.getParent();
        System.out.println(c2);

    }

    @Test
    public void testeeee() {
        System.out.println();
        System.out.println(Integer.MIN_VALUE);

        String ss="sdjfbasejakbsdfasdbfjkb看不稳接口部分就卡死按贷款你请我科达洁能两地分居阿卡丽打斯诺克未来日记哪";
        System.out.println(ss.length());
        System.out.println(ss.substring(0, 60));
    }

    @Test
    public void testobject() {
        Object[] x = new Object[100];
        Employee[] a = (Employee[]) x;


    }

    @Test
    public void testCopyOf() {
        CopyOfTest copyOfTest = new CopyOfTest();
        Integer[] a = {1, 2, 3};
//        a= (Integer[]) copyOfTest.badCopyOf(a,10);
        System.out.println(Arrays.toString(a));

        String[] b = {"tom", "Dick", "ssssdas"};
        b = (String[]) copyOfTest.goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));
    }

    @Test
    public void testlambal() {
//        System.out.println(testcatch());
        testcatch();
    }

    public void testcatch() {
        try (Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\likai\\Desktop\\yyy.txt"), "GBK");
             PrintWriter writer = new PrintWriter("out.txt")
        ) {
//            throw new Exception("sss");
            while (scanner.hasNext()) {
                String cc = scanner.next();
                System.out.println(cc);
                writer.println(cc);
            }
        } catch (Exception e) {

        } finally {
//              return 2;
            System.out.println("ssss");
        }

    }

//    public int[] twoSum(int[] nums, int target) {
//        for(int i=0;i<nums.length;i++)
//            for(int j=i+1;j<nums.length;j++)
//            {
//                if(nums[i]+nums[j]==target){
//                    return new int[]{i,j};
//                }
//            }
//        return null;
//    }


    @Test
    public void ssstestfor() {
        List<String> map = new ArrayList<>();
        for (int i = 0; i < 9999999; i++) {
            map.add("key" + i + "value" + i);
        }
        long start = System.currentTimeMillis();
        map.parallelStream().forEach((n) -> n.toUpperCase());
        long end = System.currentTimeMillis();
        System.out.println("消耗时间" + (start - end));
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < map.size(); i++) {
            map.get(i).toUpperCase();
        }
        long end1 = System.currentTimeMillis();
        System.out.println("消耗时间" + (start1 - end1));

        Collector collector;
        Map map1;
        HashMap hashMap;
        HashSet hashSet;
        AbstractSet abstractSet;
        TreeSet treeSet;
        TreeMap treeMap;
        Hashtable hashtable;
        AbstractMap abstractMap;
        AbstractList abstractList;

        List list;
        ArrayList arrayList;
        LinkedList linkedList;
        LinkedHashMap linkedHashMap;
        LinkedHashSet linkedHashSet;
        SortedMap sortedMap;
        SortedSet sortedSet;
        NavigableMap navigableMap;
        NavigableSet navigableSet;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        ConcurrentLinkedDeque concurrentLinkedDeque;
        ArrayBlockingQueue arrayBlockingQueue;
        LinkedBlockingQueue linkedBlockingQueue;
        LinkedBlockingDeque linkedBlockingDeque;
        LinkedTransferQueue linkedTransferQueue;


    }


    @Test
    public void testss() {
        while (true) {
            DirectBuffer intBuffer = (DirectBuffer) ByteBuffer.allocateDirect(1000);
        }
    }
}
