package com.brahvim.tanishq_primes_problem;

public class App {
    public static void main(final String[] args) {
        System.out.println(App.isHaningNumber(6));
        System.out.println(App.isHaningNumber(90));
        System.out.println(App.isHaningNumber(44));

        // Extra test case
        // (this is why I use `return p_number != number;`,
        // and not just `return true;`)!:
        System.out.println(App.isHaningNumber(13));
    }

    /**
     * This version uses `switch`es for checking against `int`s, and so it's faster!
     *
     * @param p_number is the number you want to check!
     * @return Is the number a haning number!?
     */
    public static boolean isHaningNumber(final int p_number) {
        if (p_number < 2) // If it is `1` or less, *nope* outta' here!
            return false;

        // Now, we know it's only positive.

        if ((p_number & 1) != 0) // Is it even?
            return false;

        // Now, we know it's only even.

        // Let's make sure it's not divisible by any other prime!:
        for (int i = 6; i < p_number; i++) // Go over all numbers that it could possible be divisible by.
            if (p_number % i == 0) { // Checking if it's divisible. Cheaper operation first.
                final int sqrt = (int) Math.round(Math.sqrt(i));
                // ^^^ `i` is an `int`, so it's okay to downcast...
                // Prime number check!:
                for (int j = 2; j < sqrt; j++) {
                    if (i % j == 0)
                        ;
                }
            }

        return p_number % 3 == 0 || p_number % 5 == 0;
    }

}
