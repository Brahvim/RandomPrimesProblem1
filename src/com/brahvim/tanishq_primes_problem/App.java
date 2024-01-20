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
     * This version allows using `long`s.
     *
     * @param p_number is the number you want to check!
     * @return Is the number a haning number!?
     */
    public static boolean isHaningNumber(final long p_number) {
        if (p_number <= 0) // If it is `0` or less, nope out!
            return false;

        if (p_number % 3 == 0)
            if ((p_number / 3) % 5 == 0)
                return true;
    }

    /**
     * This version uses `switch`es for checking against `int`s, and so it's faster!
     *
     * @param p_number is the number you want to check!
     * @return Is the number a haning number!?
     */
    public static boolean isHaningNumber(final int p_number) {
        int number = p_number;

        for (int i = 2; i < number; i++) {
            if (number % i != 0)
                continue;

            number /= i;

            // if (!(i == 2 || i == 3 || i == 5))
            // return false;

            // This should be faster if you use `int`s.
            // I'm using `long`s because I think user input should not have a small limit:

            switch (i) {
                case 2:
                case 3:
                case 5:
                    break;
                default:
                    return false;
            }
        }

        return number != p_number;
    }

}
