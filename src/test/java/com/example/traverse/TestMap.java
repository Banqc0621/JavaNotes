package com.example.traverse;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * @Author: 班前程
 * @Company:北京万相信息
 * @Description:
 * @DateTime: 2023/8/2 9:15
 **/
public class TestMap {
    //如果是 JDK8，推荐使用Map.forEach 方法（第五种方式）
    @Test
    public void testHashMap1() {
        Map<Integer, String> map = new HashMap<>();
        map.put(001, "Java");
        map.put(002, "数据库");
        map.put(003, "Vue");
        //通过Map,KeySet使用itertor遍历key,然后通过key得到对应的value值
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            String value = map.get(key);
            System.out.println("key = " + key + "value = " + value);
        }
    }

    @Test
    public void testHashMap2() {
        Map<Integer, String> map = new HashMap<>();
        map.put(001, "Java");
        map.put(002, "数据库");
        map.put(003, "Vue");
        System.out.println(map);
        // 通过Map.entrySet使用iterator遍历key,然后通过key得到对应的value值
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void testHashMap3() {
        Map<Integer, String> map = new HashMap<>();
        map.put(001, "Java");
        map.put(002, "数据库");
        map.put(003, "Vue");
        System.out.println(map);

        //FOR循环方式获取到Map的keySet,同第一种类似
        for (Integer key : map.keySet()) {
            System.out.println("key = " + key + "value = " + map.get(key));
        }
    }

    @Test
    public void testHashMap4() {
        Map<Integer, String> map = new HashMap<>();
        map.put(001, "Java");
        map.put(002, "数据库");
        map.put(003, "Vue");
        System.out.println(map);

        //FOR循环方式获取到Map的entrySet(),同第二种类似
        for (Map.Entry<Integer, String> entry : map.entrySet())
            System.out.println("key = " + entry.getKey() + "value = " + entry.getValue());
    }

    @Test
    public void testHashMap5() {
        Map<Integer, String> map = new HashMap<>();
        map.put(001, "Java");
        map.put(002, "数据库");
        map.put(003, "Vue");
        System.out.println(map);
        //从源码可以看到，这种新特性就是在传统的迭代方式上加了一层壳，但是让代码变得更加简单。（开发中推荐使用）
        map.forEach((K, V) -> System.out.println("key = " + K + "value = " + V));
      }
}
