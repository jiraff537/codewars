package com.company;

import java.util.*;
import java.util.stream.Collectors;

//https://www.codewars.com/kata/51e056fe544cf36c410000fb/train/java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        top3("a A a b c c d d d d e e e e e # / \\ \\ . '       '");
    }

    public static List<String> top3(String s) {
        List<String> list;
        list = Arrays.stream(s.chars()
                .filter(ch -> ("#\\/.".indexOf(ch) == -1))
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining())
                .toLowerCase().split(" ")).collect(Collectors.toList());

        HashMap<String, Integer> map = new HashMap<>();

        list.forEach(el -> map.merge(el, 1, Integer::sum));

        map.remove(""); //FixMe is it needed?? <<CHECK INPUT DATA
        map.remove("'");//TODO ''' won't 'and' 'and and'

        List<String> res = new ArrayList<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .forEach(m -> res.add(m.getKey()));
        return res;
    }
}

// A word is a string of letters (A to Z) optionally containing one or more apostrophes (') in ASCII.
// Apostrophes can appear at the start, middle or end of a word ('abc, abc', 'abc', ab'c are all valid)
// Any other characters (e.g. #, \, / , . ...) are not part of a word and should be treated as whitespace.
// Matches should be case-insensitive, and the words in the result should be lowercased.
// Ties may be broken arbitrarily.
// If a text consort words by length but not resort words by length but not reversed and problem with "'" sort words by length but not reversed and problem with "'" and "wat'tsort words by length but not reversed and problem with "'" and "wat't" not solved" not solvedand "wat't" not solvedversed and problem with "'" and "wat't" not solvedtains fewer than three unique words, then either the top-2 or top-1 words should be returned, or an empty array if a text contains no words.


