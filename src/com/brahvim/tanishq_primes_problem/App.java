package com.brahvim.tanishq_primes_problem;

import java.util.Scanner;

public class App {
    public static void main(final String[] args) {
        System.out.print("Please enter a number to check: ");

        final Scanner sc = new Scanner(System.in); // Make a `Scanner` to read `System.in`.
        final int number = sc.nextInt(); // Read an `int` with it,
        sc.close(); // Delete all memory `sc` used.

        boolean isHaning;

        // I'm using a do-while loop so I can use `break` instead of `return`!
        // This is a trick that C taught me :> (C macros, to be exact).
        do {
            if (number < 2) { // `1` is not a haning number either!
                isHaning = false;
                break;
            }

            // Shortcut/Optimization plus `{2, 3, 5} => true` fix:
            if (number < 7) {
                isHaning = true;
                break;
            }

            for (int i = 2; i < number; i++) {
                if (number % i != 0)
                    continue;

                // This should be faster if you use `int`s.
                // I'm using `long`s because I think user input should not have a small limit:

                // isHaning = switch (i) {
                // case 2, 3, 5 -> true;
                // default -> false;
                // };
                // break;

                isHaning = i == 2 || i == 3 || i == 5;
                break;
            }

            isHaning = false;
        } while (false);

        System.out.println(isHaning);
    }

}
