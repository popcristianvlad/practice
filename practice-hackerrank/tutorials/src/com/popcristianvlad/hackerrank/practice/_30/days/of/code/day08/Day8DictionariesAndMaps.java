package com.popcristianvlad.hackerrank.practice._30.days.of.code.day08;

import java.util.*;

public class Day8DictionariesAndMaps {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();

            map.put(name, phone);
        }

        while (in.hasNext()) {
            String s = in.next();
            Integer value = map.get(s);
            System.out.println(value == null ? "Not found" : s + "=" + value);
        }

        in.close();
    }
}
