package com.popcristianvlad.hackerrank.practice.algorithms.strings.HighestValuePalindrome;

public class HighestValuePalindrome {

    static String highestValuePalindrome(String s, int n, int k) {
        char[] array = s.toCharArray();
        int lastPosition = s.length() - 1;
        int leftCursor = n % 2 == 0 ? n / 2 - 1 : n / 2;
        int rightCursor = n / 2;

        int numberOfCharPairsNotInPlace = getNumberOfCharPairsNotInPlace(s, n, leftCursor, rightCursor);
        int extraAvailableChanges = k - numberOfCharPairsNotInPlace;

        if (extraAvailableChanges < 0) {
            return "-1";
        }

        for (int i = 0; i <= leftCursor; i++) {
            if (array[i] == array[lastPosition - i]) {
                if (array[i] != '9') {
                    if (i == leftCursor && i == rightCursor) {
                        if (extraAvailableChanges > 0) {
                            array[i] = '9';
                            extraAvailableChanges--;
                        }
                    } else {
                        if (extraAvailableChanges > 1) {
                            array[i] = '9';
                            array[lastPosition - i] = '9';
                            extraAvailableChanges -= 2;
                        }
                    }
                }
            } else {
                if (extraAvailableChanges == 0) {
                    int value1 = Integer.valueOf(array[i]);
                    int value2 = Integer.valueOf(array[lastPosition - i]);

                    if (value1 > value2) {
                        array[lastPosition - i] = array[i];
                    } else {
                        array[i] = array[lastPosition - i];
                    }
                } else {
                    // > 1
                    if (array[i] == '9' || array[lastPosition - i] == '9') {
                        // do nothing
                    } else {
                        extraAvailableChanges -= 1;
                    }
                    array[i] = '9';
                    array[lastPosition - i] = '9';
                }
            }
        }

        return String.valueOf(array);
    }

    static int getNumberOfCharPairsNotInPlace(String s, int n, int leftCursor, int rightCursor) {
        int numberOfCharPairsNotInPlace = 0;
        int pairsToCheck = leftCursor + 1;

        for (int i = 0; i < pairsToCheck; i++) {
            if (s.charAt(leftCursor) != s.charAt(rightCursor)) {
                numberOfCharPairsNotInPlace++;
            }
            leftCursor--;
            rightCursor++;
        }

        return numberOfCharPairsNotInPlace;
    }

    public static void main(String[] args) {
        System.out.println("3943->" + highestValuePalindrome("3943", 4, 1).equals("3993"));
        System.out.println("092282->" + highestValuePalindrome("092282", 6, 3).equals("992299"));
        System.out.println("0011->" + highestValuePalindrome("0011", 4, 1).equals("-1"));

        System.out.println();

        System.out.println("1->" + highestValuePalindrome("1", 1, 0).equals("1"));
        System.out.println("1->" + highestValuePalindrome("1", 1, 1).equals("9"));
        System.out.println("1->" + highestValuePalindrome("1", 1, 2).equals("9"));

        System.out.println();

        System.out.println("11->" + highestValuePalindrome("11", 2, 0).equals("11"));
        System.out.println("11->" + highestValuePalindrome("11", 2, 1).equals("11"));
        System.out.println("11->" + highestValuePalindrome("11", 2, 2).equals("99"));
        System.out.println("11->" + highestValuePalindrome("11", 2, 3).equals("99"));

        System.out.println();

        System.out.println("12->" + highestValuePalindrome("12", 2, 0).equals("-1"));
        System.out.println("12->" + highestValuePalindrome("12", 2, 1).equals("22"));
        System.out.println("12->" + highestValuePalindrome("12", 2, 2).equals("99"));
        System.out.println("12->" + highestValuePalindrome("12", 2, 3).equals("99"));

        System.out.println();

        System.out.println("04823->" + highestValuePalindrome("04823", 5, 0).equals("-1"));
        System.out.println("04823->" + highestValuePalindrome("04823", 5, 1).equals("-1"));
        System.out.println("04823->" + highestValuePalindrome("04823", 5, 2).equals("34843"));
        System.out.println("04823->" + highestValuePalindrome("04823", 5, 3).equals("94849"));
        System.out.println("04823->" + highestValuePalindrome("04823", 5, 4).equals("99899"));
        System.out.println("04823->" + highestValuePalindrome("04823", 5, 5).equals("99999"));
        System.out.println("04823->" + highestValuePalindrome("04823", 5, 6).equals("99999"));

        System.out.println();

        System.out.println("04923->" + highestValuePalindrome("04923", 5, 0).equals("-1"));
        System.out.println("04923->" + highestValuePalindrome("04923", 5, 1).equals("-1"));
        System.out.println("04923->" + highestValuePalindrome("04923", 5, 2).equals("34943"));
        System.out.println("04923->" + highestValuePalindrome("04923", 5, 3).equals("94949"));
        System.out.println("04923->" + highestValuePalindrome("04923", 5, 4).equals("99999"));
        System.out.println("04923->" + highestValuePalindrome("04923", 5, 5).equals("99999"));
        System.out.println("04923->" + highestValuePalindrome("04923", 5, 6).equals("99999"));

        System.out.println();

        System.out.println("40932->" + highestValuePalindrome("40932", 5, 0).equals("-1"));
        System.out.println("40932->" + highestValuePalindrome("40932", 5, 1).equals("-1"));
        System.out.println("40932->" + highestValuePalindrome("40932", 5, 2).equals("43934"));
        System.out.println("40932->" + highestValuePalindrome("40932", 5, 3).equals("93939"));
        System.out.println("40932->" + highestValuePalindrome("40932", 5, 4).equals("99999"));
        System.out.println("40932->" + highestValuePalindrome("40932", 5, 5).equals("99999"));
        System.out.println("40932->" + highestValuePalindrome("40932", 5, 6).equals("99999"));

        System.out.println();

        System.out.println("099982->" + highestValuePalindrome("099982", 6, 0).equals("-1"));
        System.out.println("099982->" + highestValuePalindrome("099982", 6, 1).equals("-1"));
        System.out.println("099982->" + highestValuePalindrome("099982", 6, 2).equals("299992"));
        System.out.println("099982->" + highestValuePalindrome("099982", 6, 3).equals("999999"));
        System.out.println("099982->" + highestValuePalindrome("099982", 6, 4).equals("999999"));
        System.out.println("099982->" + highestValuePalindrome("099982", 6, 5).equals("999999"));
        System.out.println("099982->" + highestValuePalindrome("099982", 6, 6).equals("999999"));
        System.out.println("099982->" + highestValuePalindrome("099982", 6, 7).equals("999999"));

        System.out.println();

        System.out.println("098882->" + highestValuePalindrome("098882", 6, 0).equals("-1"));
        System.out.println("098882->" + highestValuePalindrome("098882", 6, 1).equals("-1"));
        System.out.println("098882->" + highestValuePalindrome("098882", 6, 2).equals("298892"));
        System.out.println("098882->" + highestValuePalindrome("098882", 6, 3).equals("998899"));
        System.out.println("098882->" + highestValuePalindrome("098882", 6, 4).equals("998899"));
        System.out.println("098882->" + highestValuePalindrome("098882", 6, 5).equals("999999"));
        System.out.println("098882->" + highestValuePalindrome("098882", 6, 6).equals("999999"));
        System.out.println("098882->" + highestValuePalindrome("098882", 6, 7).equals("999999"));

        System.out.println();

        System.out.println("097882->" + highestValuePalindrome("097882", 6, 0).equals("-1"));
        System.out.println("097882->" + highestValuePalindrome("097882", 6, 1).equals("-1"));
        System.out.println("097882->" + highestValuePalindrome("097882", 6, 2).equals("-1"));
        System.out.println("097882->" + highestValuePalindrome("097882", 6, 3).equals("298892"));
        System.out.println("097882->" + highestValuePalindrome("097882", 6, 4).equals("998899"));
        System.out.println("097882->" + highestValuePalindrome("097882", 6, 5).equals("999999"));
        System.out.println("097882->" + highestValuePalindrome("097882", 6, 6).equals("999999"));
        System.out.println("097882->" + highestValuePalindrome("097882", 6, 7).equals("999999"));

        System.out.println();

        System.out.println("098982->" + highestValuePalindrome("098982", 6, 0).equals("-1"));
        System.out.println("098982->" + highestValuePalindrome("098982", 6, 1).equals("-1"));
        System.out.println("098982->" + highestValuePalindrome("098982", 6, 2).equals("-1"));
        System.out.println("098982->" + highestValuePalindrome("098982", 6, 3).equals("299992"));
        System.out.println("098982->" + highestValuePalindrome("098982", 6, 4).equals("999999"));
        System.out.println("098982->" + highestValuePalindrome("098982", 6, 5).equals("999999"));
        System.out.println("098982->" + highestValuePalindrome("098982", 6, 6).equals("999999"));
        System.out.println("098982->" + highestValuePalindrome("098982", 6, 7).equals("999999"));

        System.out.println();

        System.out.println("099882->" + highestValuePalindrome("099882", 6, 0).equals("-1"));
        System.out.println("099882->" + highestValuePalindrome("099882", 6, 1).equals("-1"));
        System.out.println("099882->" + highestValuePalindrome("099882", 6, 2).equals("-1"));
        System.out.println("099882->" + highestValuePalindrome("099882", 6, 3).equals("299992"));
        System.out.println("099882->" + highestValuePalindrome("099882", 6, 4).equals("999999"));
        System.out.println("099882->" + highestValuePalindrome("099882", 6, 5).equals("999999"));
        System.out.println("099882->" + highestValuePalindrome("099882", 6, 6).equals("999999"));
        System.out.println("099882->" + highestValuePalindrome("099882", 6, 7).equals("999999"));

        System.out.println();

        System.out.println("908982->" + highestValuePalindrome("908982", 6, 0).equals("-1"));
        System.out.println("908982->" + highestValuePalindrome("908982", 6, 1).equals("-1"));
        System.out.println("908982->" + highestValuePalindrome("908982", 6, 2).equals("-1"));
        System.out.println("908982->" + highestValuePalindrome("908982", 6, 3).equals("989989"));
        System.out.println("908982->" + highestValuePalindrome("908982", 6, 4).equals("999999"));
        System.out.println("908982->" + highestValuePalindrome("908982", 6, 5).equals("999999"));
        System.out.println("908982->" + highestValuePalindrome("908982", 6, 6).equals("999999"));
        System.out.println("908982->" + highestValuePalindrome("908982", 6, 7).equals("999999"));
    }
}
