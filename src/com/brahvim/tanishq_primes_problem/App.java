package com.brahvim.tanishq_primes_problem;

public class App {
    public static void main(final String[] args) {
        System.out.println("Original test cases:");

        System.out.printf("`6` is %s haning number.%n", App.isHaningNumber(6) ? "a" : "not a");
        System.out.printf("`90` is %s haning number.%n", App.isHaningNumber(90) ? "a" : "not a");
        System.out.printf("`44` is %s haning number.%n", App.isHaningNumber(44) ? "a" : "not a");

        System.out.printf("%n%nExtra test cases:%n");
        // Extra test case
        // (this is why I use `return p_number != number;`,
        // and not just `return true;`)!:
        System.out.printf("`13` is %s haning number.%n", App.isHaningNumber(13) ? "a" : "not a");
        System.out.printf("`-1` is %s haning number.%n", App.isHaningNumber(-1) ? "a" : "not a");

        System.out.printf("%n%nFrom `1` to `10`:%n");
        for (int i = 1; i < 11; i++)
            System.out.printf("%d) `%s`.%n", i, App.isHaningNumber(i));

        /*
         * From `1` to `10`:
         * 1) `false`.
         * 2) `true`.
         * 3) `true`.
         * 4) `true`.
         * 5) `true`.
         * 6) `true`.
         * 7) `false`.
         * 8) `true`.
         * 9) `true`.
         * 10) `true`.
         */
    }

    public static boolean isHaningNumber(final int p_number) {
        if (p_number < 2) // `1` is not a haning number either!
            return false;

        // Shortcut/Optimization plus `{2, 3, 5} => true` fix:
        if (p_number < 7)
            return true;

        for (int i = 2; i < p_number; i++) {
            if (p_number % i != 0)
                continue;

            // A `switch` is MUCH faster than an `if`. If you the JVM's bytecode, you'll
            // see (I actually tried this on [ https://godbolt.org ]!):
            return switch (i) {
                case 2, 3, 5 -> true;
                default -> false;
            };

            // This is necessary when using `long`s/`float`s`/`double`s.
            // Don't forget to suffix the numbers with `L`/`f`/`d`!:
            // return i == 2 || i == 3 || i == 5;
        }

        return false;
    }

}
