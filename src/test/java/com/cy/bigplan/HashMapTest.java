package com.cy.bigplan;

import org.junit.jupiter.api.Test;
import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapTest {
    @Test
    public void objectTest() {
        //测试对象的创建和引用
        HashMap<String, List<String>> hashMap = new HashMap<>();
        List<String> ListForTest = new ArrayList<>();
        ListForTest.add("1");
        hashMap.put("key", ListForTest);
        System.out.println(hashMap.get("key"));//[1]
        hashMap.get("key").add("2");
        System.out.println(hashMap.get("key"));//[1,2]

        //getOrDefault 不会修改Map而只是返回一个预设的值
        List<String> list = hashMap.getOrDefault("key1", new ArrayList<>());
        list.add("a");
        System.out.println(hashMap.get("key1"));//null

        //keySet 也是一个引用，而不是复制,同时也说明HashMap中存储的是对象的引用
        List<String> list1 = new ArrayList<>();
        hashMap.put("keySet",list1);
        list1.add("3");
        System.out.println(hashMap);
        hashMap.keySet().remove("keySet");
        System.out.println(hashMap);
    }

}
