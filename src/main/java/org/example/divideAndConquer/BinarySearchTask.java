package org.example.divideAndConquer;

import java.util.Scanner;

/**
 * task description on https://stepik.org/lesson/13246/step/4?unit=3431
 */

public class BinarySearchTask {

    public static void main(String[] args) {
        resolveTask();
    }

    static void resolveTask() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sortArray = new int[n];
        for (int i = 0; i < n; i++) {
            sortArray[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        int[] searchingNumbers = new int[k];
        for (int i = 0; i < k; i++) {
            searchingNumbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < k; i++) {
            System.out.print(binarySearch(sortArray, searchingNumbers[i]) + " ");
        }
    }

    static int binarySearch(int[] sortArray, int k) {
        int start = 0;
        int end = sortArray.length - 1;
        int m = (start + end) / 2;
        while (start <= end) {
            if (k > sortArray[m]) {
                start = m + 1;
            } else if (k == sortArray[m]) {
                return m + 1;
            } else {
                end = m - 1;
            }
            m = (start + end) / 2;
        }
        return -1;
    }
}
