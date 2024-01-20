package com.brahvim.tanishq_primes_problem;

public class App {
    public static void main(final String[] args) {
        System.out.println("Original test cases:");

        System.out.printf("`6` is %s haning number.%n", App.isHaningNumberOld(6) ? "a" : "not a");
        System.out.printf("`90` is %s haning number.%n", App.isHaningNumberOld(90) ? "a" : "not a");
        System.out.printf("`44` is %s haning number.%n", App.isHaningNumberOld(44) ? "a" : "not a");

        System.out.printf("%n%nExtra test case:%n");
        // Extra test case
        // (this is why I use `return p_number != number;`,
        // and not just `return true;`)!:
        System.out.printf("`13` is %s haning number.%n", App.isHaningNumberOld(13) ? "a" : "not a");
        System.out.printf("`-1` is %s haning number.%n", App.isHaningNumberOld(-1) ? "a" : "not a");

        System.out.printf("%n%nFrom `1` to `10`:%n");
        for (int i = 1; i < 11; i++)
            System.out.printf("%d) `%s`.%n", i, App.isHaningNumberOld(i));
    }

    public static boolean isHaningNumberOld(final int p_number) {
        int number = p_number;

        if (p_number < 2) // `1` is not a haning number either!
            return false;

        // Shortcut/Optimization plus `{2, 3, 5} => true` fix:
        if (p_number < 7)
            return true;

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
                    return true;
                default:
                    return false;
            }
        }

        return number != p_number;
    }

}
