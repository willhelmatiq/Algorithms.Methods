package org.example.greedyAlgorithms;

import java.util.Scanner;

/**
 * task description on https://stepik.org/lesson/13238/step/11?unit=3424
 */

public class VariousAdditions {

    public static void main(String[] args) {
        printAdditiveNumber();
    }

    static void printAdditiveNumber() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double root;
        root = (Math.sqrt(1 + 8L * n) - 1) /2;      //root of equation (1+k)*k/2 = n
        int k = (int) root;
        System.out.println(k);
        for(int i = 0; i < k - 1; i++) {
            System.out.print(i + 1 + " ");
        }
        if (root - (double) k == 0.0) {
            System.out.print(k);
        } else {
            System.out.print(n - k*(k-1)/2);        // (1 + k-1)*(k-1)/2
        }
    }
}
