package com.brahvim.tanishq_primes_problem;

public class App {
    public static void main(final String[] args) {
        // System.out.println(App.isHaningNumber(6));
        // System.out.println(App.isHaningNumber(90));
        // System.out.println(App.isHaningNumber(44));

        System.out.println(App.isHaningNumber(13));
    }

    public static boolean isHaningNumber(final long p_number) {
        long number = p_number;

        for (long i = 2; i < number; i++) {
            if (number % i != 0)
                continue;

            // This checks if final we can still divide:
            final float div = (float) number / (float) i;
            if (div != number / i)
                ; // Can't divide anymore!

            number /= i;

            if (!(i == 2 || i == 3 || i == 5))
                return false;

            // This should be faster if you use `int`s.
            // I'm using `long`s because I think user input should not have a small limit:

            /*
             * switch (i) {
             * case 2:
             * case 3:
             * case 5:
             * break;
             * default:
             * return false;
             * break;
             * }
             */
        }

        return number == p_number;
    }

}
