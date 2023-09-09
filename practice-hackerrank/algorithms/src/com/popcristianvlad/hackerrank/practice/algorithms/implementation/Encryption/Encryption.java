package com.popcristianvlad.hackerrank.practice.algorithms.implementation.Encryption;

public class Encryption {

    static String encryption(String s) {
        int stringLength = s.length();
        double sqrtLength = Math.sqrt(stringLength);
        int numberOfRows = (int) Math.floor(sqrtLength);
        int numberOfColumns = (int) Math.ceil(sqrtLength);

        if (numberOfRows * numberOfColumns < stringLength) {
            numberOfRows++;
        }
        char[][] encryptionMatrix = new char[numberOfRows][numberOfColumns];


        int rowPosition = 0;
        int columnPosition = 0;
        for (char character : s.toCharArray()) {
            if (columnPosition == numberOfColumns) {
                columnPosition = 0;
                rowPosition++;
            }

            encryptionMatrix[rowPosition][columnPosition] = character;
            columnPosition++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfColumns; i++) {
            for (int j = 0; j < numberOfRows; j++) {
                char currentCharacter = encryptionMatrix[j][i];
                if (currentCharacter != '\u0000') {
                    sb.append(currentCharacter);
                } else {
                    break;
                }
            }
            sb.append(' ');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots";
        String result = encryption(s);
        System.out.println(result);

        s = "feedthedog";
        result = encryption(s);
        System.out.println(result);

        s = "chillout";
        result = encryption(s);
        System.out.println(result);
    }
}
