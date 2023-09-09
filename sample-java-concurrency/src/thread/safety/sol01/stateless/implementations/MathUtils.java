package thread.safety.sol01.stateless.implementations;

import java.math.BigInteger;

public class MathUtils {

    /**
     * This method is a stateless deterministic function. Given a specific input, it always produces the same output.
     * The method neither relies on external state nor maintains state at all. So, it's considered to be thread-safe
     * and can be safely called by multiple threads at the same time. All threads can safely call the factorial() method
     * and will get the expected result without interfering with each other and without altering the output that the
     * method generates for other threads.
     * Therefore, stateless implementations are the simplest way to achieve thread-safety.
     */
    public static BigInteger factorial(int number) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= number; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
    }
}
