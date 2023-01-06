package org.example.divideAndConquer;

import java.util.Scanner;

/**
 * task description on https://stepik.org/lesson/13248/step/5?unit=3433
 */

public class InversionCountTask {
    static long invCount = 0;

    public static void main(String[] args) {
        resolveTask();
    }

    static void resolveTask() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length-1)));
        mergeSort(arr, 0, arr.length-1);
        System.out.println(invCount);
    }

    static int inversionCountingN2(int[] arr) {
        int invCount = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[i] > arr[j+1]) {
                    invCount++;
                }
            }
        }
        return invCount;
    }

    static int[] mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r)/2;
            return merge(mergeSort(arr, l, m), mergeSort(arr, m+1, r));
        } else {
            return new int[]{arr[l]};
        }
    }

    static int[] merge(int[] left, int[] right) {
        int pointerL = 0;
        int pointerR = 0;
        int[] resultArr = new int[left.length + right.length];
        while (pointerL + pointerR < resultArr.length) {
            if (pointerL < left.length && pointerR < right.length) {
                if (left[pointerL] > right[pointerR]) {
                    resultArr[pointerL + pointerR] = right[pointerR];
                    pointerR++;
                    invCount += left.length - pointerL;
                } else {
                    resultArr[pointerL + pointerR] = left[pointerL];
                    pointerL++;
                }
            } else {
                if (pointerL < left.length) {
                    resultArr[pointerL + pointerR] = left[pointerL];
                    pointerL++;
                }
                if (pointerR < right.length) {
                    resultArr[pointerL + pointerR] = right[pointerR];
                    pointerR++;
                }
            }
        }
        return resultArr;
    }
}
