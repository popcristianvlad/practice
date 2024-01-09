package x07-java.x02-strings;

import java.util.*;

public class JavaStringReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        StringBuilder sb = new StringBuilder(A);
        String reversedA = sb.reverse().toString();

        System.out.println(A.equals(reversedA) ? "Yes" : "No");
    }
}
