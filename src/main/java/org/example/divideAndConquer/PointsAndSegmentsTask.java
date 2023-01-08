package org.example.divideAndConquer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * task description on https://stepik.org/lesson/13249/step/6?unit=3434
 */

public class PointsAndSegmentsTask {

    public static void main(String[] args) {
        resolveTask();
    }

    static void resolveTask() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] segmentsStart = new int[n];
        int[] segmentsEnd = new int[n];
        for (int i = 0; i < n; i++) {
            segmentsStart[i] = scanner.nextInt();
            segmentsEnd[i] = scanner.nextInt();
        }
        int[] points = new int[m];
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }

        quickSort(segmentsStart, 0, n - 1);
        quickSort(segmentsEnd, 0, n - 1);
        System.out.println(Arrays.toString(segmentsStart));
        System.out.println(Arrays.toString(segmentsEnd));
        for (int i : points) {
            int a = binaryPosSearch(segmentsStart, i);
            int b = binaryPosSearch(segmentsEnd, i - 1);
            System.out.print(a - b + " ");
        }
    }

    static void quickSort(int[] arr, int l, int r) {
        while (l < r) {
            int m = partition(arr,  l,  r);
            if (m > (l + r) / 2) {
                quickSort(arr, m + 1, r);
                r = m - 1;
            } else {
                quickSort(arr, l, m - 1);
                l = m + 1;
            }
        }
    }

    static int partition(int[] arr, int l, int r) {
        int x = pickSupportElement(arr, l, r);
        int j = l;
        for (int i = j + 1; i <= r; i++) {
            if (arr[i] <= x) {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[l];
        arr[l] = temp;
        return j;
    }

    static int pickSupportElement(int[] arr, int l, int r) {
        int start = arr[l];
        int end = arr[r];
        int mid = arr[(l + r) / 2];
        if (isMedianOfThree(start, mid, end) == mid) {
            arr[l] = mid;
            arr[(l + r) / 2] = start;
        } else if (isMedianOfThree(start, mid, end) == end) {
            arr[l] = end;
            arr[r] = start;
        }
        return arr[l];
    }

    static int isMedianOfThree(int a, int b, int c) {
        if (a < b) {
            return Math.max(a, c);
        } else if (a == b){
            return a;
        } else {
            return Math.max(b, c);
        }
    }

    static int binaryPosSearch(int[] sortArray, int k) {
        int start = 0;
        int end = sortArray.length - 1;
        int m = (start + end) / 2;
        while (start <= end) {
            if (k >= sortArray[m]) {
                start = m + 1;
                if (start > end) {
                    return end + 1;
                }
            } else {
                end = m - 1;
                if (start > end) {
                    return start;
                }
            }
            m = (start + end) / 2;
        }
        return m + 1;
    }
}
