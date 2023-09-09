package com.popcristianvlad.hackerrank.practice._30.days.of.code.day12;

import java.util.Arrays;
import java.util.Scanner;

class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    Person(String firstName, String lastName, int identification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    public void printPerson() {
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + "\nID: " + idNumber);
    }
}

class Student extends Person {

    private int[] testScores;

    public Student(String firstName, String lastName, int identification, int[] testScores) {
        super(firstName, lastName, identification);
        this.testScores = testScores;
    }

    public String calculate() {
        Integer sum = Arrays.stream(testScores).sum();
        double average = sum / testScores.length;

        if (90 <= average && average <= 100) {
            return "O";
        }

        if (80 <= average && average < 90) {
            return "E";
        }

        if (70 <= average && average < 80) {
            return "A";
        }

        if (55 <= average && average < 70) {
            return "P";
        }

        if (40 <= average && average < 55) {
            return "D";
        }

        return "T";
    }
}

public class Day12Inheritance {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for (int i = 0; i < numScores; i++) {
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate());
    }
}
