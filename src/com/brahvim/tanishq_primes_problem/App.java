package com.brahvim.tanishq_primes_problem;

public class App {
    public static void main(final String[] args) {
        // System.out.println(App.isHaningNumberOld(6));
        // System.out.println(App.isHaningNumberOld(90));
        // System.out.println(App.isHaningNumberOld(44));

        // Extra test case
        // (this is why I use `return p_number != number;`,
        // and not just `return true;`)!:
        // System.out.println(App.isHaningNumberOld(13));

        // for (int i = 0; i < 10; i++)
        // System.out.printf("%d) `%s`.%n", i, App.isHaningNumberOld(i));

        for (int i = 0; i < 10; i++) {
            final boolean oldHan = App.isHaningNumberOld(i), newHan = App.isHaningNumber(i);
            if (oldHan != newHan)
                System.out.printf("%d) Old: `%s`, new: `%s`.%n", i, oldHan, newHan);
        }
    }

    public static boolean isHaningNumberOld(final int p_number) {
        int number = p_number;

        if (p_number < 2) // `1` is not a hanning number either!
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

    /**
     * @param p_number is the number you want to check!
     * @return Is the number a haning number!?
     */
    public static boolean isHaningNumber(final int p_number) {
        if (p_number < 2) // If it is `1` or less, *nope* outta' here!
            return false;

        if (p_number < 7) // If it's `6` or less...
            return true; // PS This check is NECESSARY.
        // The last `return` statement IGNORES numbers less than `4`
        // (could be upto `6`, methinks!).

        // Now, we know it's only positive.

        if ((p_number & 1) != 0) // Is it even?
            return false;

        // Now, we know it's only even.

        // Let's make sure it's not divisible by any other prime!:
        for (int i = 6; i < p_number; i++) // Go over all numbers that it could possible be divisible by.
            // Checking if it's divisible. Cheaper operation first:
            if (p_number % i == 0)
                if (App.isPrime(i)) // If it's divisible by a prime, we're out!
                    return false;

        return p_number % 3 == 0 || p_number % 5 == 0;
    }

    // (I've been preparing this algorithm for **years**. It's my personal secret.)
    public static boolean isPrime(final int p_number) {
        final int sqrt = (int) Math.sqrt(p_number);

        if (p_number < 2)
            return false;

        for (int i = 2; i <= sqrt; i++)
            if (p_number % i == 0)
                return false;

        return true;
    }

}
