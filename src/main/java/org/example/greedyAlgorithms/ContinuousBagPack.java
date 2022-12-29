package org.example.greedyAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * task description on https://stepik.org/lesson/13238/step/10?unit=3424
 */

public class ContinuousBagPack {

    public static void main(String[] args) {
        printBagCost();
    }

    static void printBagCost() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double w = scanner.nextInt();
        double[][] items = new double[n][2];
        for (int i = 0; i < n; i++) {
            double a = scanner.nextInt();
            double b = scanner.nextInt();
            items[i][0] = b;
            items[i][1] = a / b;
        }
        Arrays.sort(items, ((o1, o2) -> Double.compare(o2[1], o1[1])));
        double currentWeight = 0;
        double currentCost = 0;
        int i = 0;
        while (currentWeight < w && i < n) {
            if (items[i][0] <= w - currentWeight) {
                currentWeight += items[i][0];
                currentCost += items[i][0] * items[i][1];
                i++;
            } else {
                currentCost += (w - currentWeight) * items[i][1];
                currentWeight += (w - currentWeight);
            }
        }
        System.out.printf("%.3f%n", currentCost);
    }
}
