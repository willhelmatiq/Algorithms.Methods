package org.example.theoryAndPractise.GCD;

import java.util.Scanner;

/**
 * task description on https://stepik.org/lesson/13229/step/5?unit=3415
 */

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(remnantEuclidean(n, m));
    }

    static int remnantEuclidean(int a, int b) {
        int first = Integer.max(a, b);
        int second = Integer.min(a, b);
        if (second == 0) {
            return first;
        } else {
            return remnantEuclidean(first % second, second);
        }
    }
}
