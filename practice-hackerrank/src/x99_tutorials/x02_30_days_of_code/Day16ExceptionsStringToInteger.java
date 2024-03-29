package x99_tutorials.x02_30_days_of_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day16ExceptionsStringToInteger {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();

        try {
            System.out.println(Integer.parseInt(S));
        } catch (NumberFormatException ex) {
            System.out.println("Bad String");
        }

        bufferedReader.close();
    }
}
