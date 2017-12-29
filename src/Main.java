import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    protected static String a() {
        return "a";
    }
    public static void main(String[] args) {
        String b = "b";

        System.out.println(b + 1);
    }
//    static int a = 0;
//
//    synchronized public static void testLock() {
//        a++;
//        System.out.println(0);
//    }
//
//    public static void testLock2() {
//        synchronized (Main.class) {
//            a++;
//        }
//        System.out.println(0);
//    }
//
//    public static void main(String[] args) {
//        Main m = new Main();
//        System.gc();
//        System.out.println("Hello World!");
//        Collections.synchronizedCollection();
//        ConcurrentHashMap
//    }
}
