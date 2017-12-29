package com.baidu.unused;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by baidu on 17/5/17.
 */
public class RegularTask {
    int a = 1;

    void r(int a) {
        System.out.println("r");
    }

    void r(char a) {
        System.out.println("ra");
    }

//    static class B extends RegularTask {
//        public void r(int a) {
//            System.out.println("b");
//        }
//    }

    static volatile int sum = 0;

    static void inc() {
        sum++;
    }

    public static void testVolatile() {
        int n = 10;
        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < n; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        inc();
                    }
                }
            });
            t.start();
            threads.add(t);
        }
        for (int i = 0; i < n; i++) {
            if (Thread.activeCount() > 1) {
                Thread.yield();
            }
        }
        System.out.println(sum);
    }

//    static public void aa(List<Integer> a) {}

    static public int aa(List<String> a) {
        return 1;
    }
    static class A {
        static {
            try {
                Thread.sleep(100000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        Thread th = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("start");
//                new A();
//                System.out.println("end");
//            }
//        });
//        th.start();
//        Thread th2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("start");
//                new A();
//                System.out.println("end");
//            }
//        });
//        th2.start();
        new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                InputStream is = getClass().getClassLoader().getResourceAsStream("java/lang/Object.class");
                try {
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new ClassNotFoundException(ex.getMessage());
                }
            }
        }.loadClass("java.lang.Object");
//        testVolatile();
//        RegularTask b = new B();
//        b.r(1   );
//        Runnable task = new Runnable() {
//            public void run() {
//                try {
//                    System.out.println("start " + new Date());
//                    Thread.sleep(7000);
//                    System.out.println("end " + new Date());
//                } catch (Exception ex) {
////                    logger.error(String.format("Fail to run scheduled task [%s] status, reason: %s", this, ex.toString()));
//                }
//            }
//        };
//        ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(2);
//        scheduledService.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
    }

}
