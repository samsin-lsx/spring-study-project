package org.samsin.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李尚兴
 * @create 2019-12-22 21:22
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println("Hello World！");
        Map<String, String> map = new HashMap<>();
        map.put("name", "samsin");
        map.put("age", "30");
        String age = map.get("age");
        System.out.println("age = " + age);
    }
}
