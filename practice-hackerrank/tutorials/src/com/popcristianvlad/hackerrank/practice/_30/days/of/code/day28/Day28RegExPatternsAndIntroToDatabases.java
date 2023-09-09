package com.popcristianvlad.hackerrank.practice._30.days.of.code.day28;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;

public class Day28RegExPatternsAndIntroToDatabases {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> names = new ArrayList<>();

        IntStream.range(0, N).forEach(NItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                String firstName = firstMultipleInput[0];
                String emailID = firstMultipleInput[1];

                Pattern pattern = Pattern.compile("^(.+)@gmail.com");
                Matcher m = pattern.matcher(emailID);

                if (m.matches()) {
                    names.add(firstName);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        names.sort(String::compareTo);
        names.forEach(System.out::println);

        bufferedReader.close();
    }
}
