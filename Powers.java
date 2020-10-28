/*
Emily Farrell
CSC 360
Powers.java
This program uses various recursive and iterative methods to manually find the value
of a user-inputted positive integer to the n-th power. This calculation is checked against
Java's Math.pow function for accuracy. Each method also prints, alongside its answer, the
 number of multiplication operations that were required to complete the calculation.
 */

import java.util.Scanner;

public class Powers {
    private static int multiplications; // global variable for counting the number of
                                        // multiplications performed by each method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get input
        System.out.print("Enter a decimal number: ");
        double base = input.nextDouble();

        int n;

        do {
            System.out.print("Enter a non-negative integer exponent: ");
            n = input.nextInt();
            if (n < 0) {
                System.out.println("Invalid input: " + n);
            }
        } while (n < 0);
        input.close();

        // Compute base to the n-th power
        System.out.println("\nComputing " + base + " to the power " + n + ":");
        System.out.println("Math.pow(" + base + ", " + n + ") = " + Math.pow(base,n));

        multiplications = 0;
        System.out.println("\npower1(" + base + ", " + n + ") = " + power1(base, n));
        System.out.println("Multiplications = " + multiplications);


        multiplications = 0;
        System.out.println("\npower2(" + base + ", " + n + ") = " + power2(base, n));
        System.out.println("Multiplications = " + multiplications);

        multiplications = 0;
        System.out.println("\npower3(" + base + ", " + n + ") = " + power3(base, n));
        System.out.println("Multiplications = " + multiplications);

        multiplications = 0;
        System.out.println("\npower4(" + base + ", " + n + ") = " + power4(base, n));
        System.out.println("Multiplications = " + multiplications);

        multiplications = 0;
        System.out.println("\npower5(" + base + ", " + n + ") = " + power5(base, n));
        System.out.println("Multiplications = " + multiplications);
    }

    // Returns base to the n-th power.
    // Iterative method.
    public static double power1(double base, long n) {
        double result = 1.0;
        for (long i = 0; i < n; i++)
        {
            result *= base;
            multiplications++;
        }

        return result;
    }

    public static double power2(double base, long n) {
        if (n == 0)
            return 1.0;
        if (n > 0)
            multiplications++;
            return base * power2(base, n - 1);
    }

    public static double power3(double base, long n) {
        if (n == 0){
            return 1.0;}
        else if (n % 2 == 0) {
            double subResult = power3(base, n / 2);
            multiplications++;
            return subResult * subResult;
        } else {
            double subResult = power3(base, n / 2);
            multiplications++;
            multiplications++;
            return base * subResult * subResult;
        }
    }

    public static double power4(double base, long n){
        return multPow(1, base, n);
    }

    private static double multPow(double a, double b, long n) {
        if (n == 0) {
            return a; }
        else if (n % 2 == 0) {
            multiplications++;
            return multPow(a, b * b, n / 2);
        }
        else {
            multiplications++;
            multiplications++;
            return multPow(a*b,b*b,n/2);
        }
    }

    public static double power5(double base, long n) {
        double a = 1.0;
        while (n > 0)
            if (n % 2 == 0) {
                base *= base;
                n /= 2;
                multiplications++;
            }
            else {
                a *= base;
                base *= base;
                n /= 2;
                multiplications++;
                multiplications++;
            }
        return a;
    }
}


/*
sample session #1
Enter a decimal number: 1.001
Enter a non-negative integer exponent: 1000

Computing 1.001 to the power 1000:
Math.pow(1.001, 1000) = 2.7169239322355936

power1(1.001, 1000) = 2.7169239322355985
Multiplications = 1000

power2(1.001, 1000) = 2.7169239322355985
Multiplications = 1000

power3(1.001, 1000) = 2.716923932235485
Multiplications = 16

power4(1.001, 1000) = 2.7169239322355203
Multiplications = 16

power5(1.001, 1000) = 2.7169239322355203
Multiplications = 16




sample session #2

Enter a decimal number: 2
Enter a non-negative integer exponent: 4

Computing 2.0 to the power 4:
Math.pow(2.0, 4) = 16.0

power1(2.0, 4) = 16.0
Multiplications = 4

power2(2.0, 4) = 16.0
Multiplications = 4

power3(2.0, 4) = 16.0
Multiplications = 4

power4(2.0, 4) = 16.0
Multiplications = 4

power5(2.0, 4) = 16.0
Multiplications = 4
 */