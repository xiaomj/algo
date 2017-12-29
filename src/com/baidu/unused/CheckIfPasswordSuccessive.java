package com.baidu.unused;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by baidu on 17/8/25.
 */
public class CheckIfPasswordSuccessive {


    class Person {
        String name;
        Boolean isPreme;
    }

    class Department {
        List<Person> people;
        List<Department> subDepartments;
    }

    protected void listPersonForDepartment(Department department) {
        if (department.subDepartments != null
                && department.subDepartments.size() > 0) {
            for (Department dep: department.subDepartments) {
                listPersonForDepartment(dep);
            }
        }
        if (department.people != null
                && department.people.size() > 0) {
            for (Person p: department.people) {
                System.out.println(p);
            }
        }
    }

//    public static void main(String[] args) {
//        Department department = new Department();
//        department.subDepartments = new ArrayList<>();
//
//        List<Department> subDepartments = new ArrayList<>();
//
//        department.subDepartments = subDepartments;
//    }


    private static void setReplaceList(String password, int i, List<String> resListStr) {
        String similarArr[] = {
                "a@",
                "b6",
                "li!1"
        };
        for (int j = 0; j < similarArr.length; j++) {
            if (similarArr[j].indexOf(password.substring(i, i+1)) != -1) {
                for (int z = 0; z < similarArr[j].length(); z++) {
                    resListStr.add(password.substring(0, i) + similarArr[z] + password.substring(i+1));
                }
            }
        }
    }

    public List<String> generateSimilarStrings(String src, int i) {
        List<String> resultStrings = new ArrayList<>();

        return resultStrings;
    }


    static Map<Character, Character> map = new HashMap<>();
    static {
        map.put('o', '0');
        map.put('0', 'o');
        map.put('9', 'g');
        map.put('g', '9');
    }



    protected static void recursiveReplace(String src, List<String> results) {
        if (src.length() == 1) {
            results.add(src);
            return;
        }
        Character ch = src.charAt(0);
        List<String> subs = new ArrayList<>();
        recursiveReplace(src.substring(1), subs);

        for (String s: subs) {
            if (map.containsKey(ch)) {
                results.add(map.get(ch) + s);
            }
            results.add(ch + s);
        }
        Charset charset = Charset.forName("UTF8");
    }

    protected static void testScheduled() {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("run");
            }
        };
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(runnable, -1, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {

        testScheduled();
//        String password = "test";
//        String src = "o09232sd";
//        List<String> subs = new ArrayList<>();
//        recursiveReplace(src, subs);
//        for (String s: subs) {
//            System.out.println(s);
//        }
    }
}
