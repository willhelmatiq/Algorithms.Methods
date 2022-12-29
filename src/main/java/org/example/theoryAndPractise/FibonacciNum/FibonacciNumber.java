package org.example.theoryAndPractise.FibonacciNum;

import java.util.Scanner;

/**
 * task description on https://stepik.org/lesson/13228/step/6?unit=3414
 */

public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(getFibonacciNumber(a));
    }

    static long getFibonacciNumber(long a) {
        if (a <= 1) {
            return a;
        } else {
            return (getFibonacciNumber(a - 1) + getFibonacciNumber(a - 2));
        }

    }
}
