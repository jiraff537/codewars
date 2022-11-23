package com.company;

import java.util.*;
import java.util.stream.Collectors;

//https://www.codewars.com/kata/51e056fe544cf36c410000fb/train/java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        top3("a a a  b  c c  d d d d  e e e e e");
    }

    public static List<String> top3(String s) {
        // Your code here
        List<String> list;
        list = (List<String>) Arrays.stream(s.split(" ")).collect(Collectors.toList());
        HashMap<String, Integer > map = new HashMap<>();
        for (String el: list
        ) {
            System.out.println("list.el = "+el);
            Integer integer = map.get(el) != null ? map.put(el, map.get(el) + 1) : map.put(el, 1);
        };

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

//        for (String m: map.keySet()) {
//            System.out.println(m +" m  "+ m);
//        }
        return null;
    }
}
