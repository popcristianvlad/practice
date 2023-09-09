package com.popcristianvlad.hackerrank.practice.algorithms.sorting.IntroToTutorialChallenges;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result3 {

    public static int introTutorial(int V, List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == V) {
                return i;
            }
        }

        // won't be the case
        return 0;
    }
}

public class IntroToTutorialChallenges {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int V = Integer.parseInt(bufferedReader.readLine().trim());

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result3.introTutorial(V, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
