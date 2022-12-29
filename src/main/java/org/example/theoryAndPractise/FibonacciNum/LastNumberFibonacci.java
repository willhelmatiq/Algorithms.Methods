package org.example.theoryAndPractise.FibonacciNum;

import java.util.Scanner;

/**
 * task description on https://stepik.org/lesson/13228/step/7?unit=3414
 */


public class LastNumberFibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(getLastNumberFibonacci(a));
    }

    static int getLastNumberFibonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        if (n == 0) {
            return a;
        }
        else if (n == 1) {
            return b;
        }
        else {
            for (int i = 2; i <= n; i++) {
                c = (a + b)%10;
                a = b;
                b = c;
            }
        }
        return c;
    }
}
