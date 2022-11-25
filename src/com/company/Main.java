package com.company;

import java.util.*;
import java.util.stream.Collectors;

//https://www.codewars.com/kata/51e056fe544cf36c410000fb/train/java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        top3("a A a b c c d d d d e e e e e # / \\ \\ . '       '"); //FixMe did'nt solved case wht double spaces
    }

    public static List<String> top3(String s) {
        // Your code here
        List<String> list;
        list =  Arrays.stream(s.chars()
                .filter(ch ->  ("#\\/.".indexOf(ch)==-1)  )
                .mapToObj(ch -> String.valueOf((char)ch))
                .collect(Collectors.joining())

                .toLowerCase().split(" ")).collect(Collectors.toList());

        HashMap<String, Integer > map = new HashMap<>();
        for (String el: list
        ) {
            System.out.println("list.el = "+el);

            if (map.get(el) != null ) {
                map.put(el, map.get(el) + 1);
            } else{
                map.put(el, 1);
            }
        };
        map.remove(""); //FixMe is it needed??
        map.remove("'");//todo ''' won't 'and' 'and and'


        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
//        //TODO QQQ в forEach засунуть дабавление в очередь?
//        Queue<String> to3Q = ArrayDeque();

//        for (String m: map.keySet()) {
//            System.out.println(m +" m  "+ m);
//        }
        return null;
    }
};;

//todo A word is a string of letters (A to Z) optionally containing one or more apostrophes (') in ASCII.
//. Apostrophes can appear at the start, middle or end of a word ('abc, abc', 'abc', ab'c are all valid)
//. Any other characters (e.g. #, \, / , . ...) are not part of a word and should be treated as whitespace.
//. Matches should be case-insensitive, and the words in the result should be lowercased.
//. Ties may be broken arbitrarily.
//. If a text consort words by length but not resort words by length but not reversed and problem with "'" sort words by length but not reversed and problem with "'" and "wat'tsort words by length but not reversed and problem with "'" and "wat't" not solved" not solvedand "wat't" not solvedversed and problem with "'" and "wat't" not solvedtains fewer than three unique words, then either the top-2 or top-1 words should be returned, or an empty array if a text contains no words.


