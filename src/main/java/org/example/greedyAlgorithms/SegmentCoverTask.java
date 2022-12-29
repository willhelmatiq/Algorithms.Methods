package org.example.greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * task description on https://stepik.org/lesson/13238/step/9?unit=3424
 */


public class SegmentCoverTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] segmentArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            segmentArr[i][0] = scanner.nextInt();
            segmentArr[i][1] = scanner.nextInt();
        }
        segmentCover(segmentArr);
    }

    static void segmentCover(int [][] segmentArr) {
        Arrays.sort(segmentArr, ((o1, o2) -> Integer.compare(o1[1], o2[1])));
        int i = 0;
        int j = 1;
        ArrayList<Integer> resultPoints = new ArrayList<>();
        while (i + j < segmentArr.length){
            if (segmentArr[i][1] < segmentArr[i + j][0]){
                resultPoints.add(segmentArr[i][1]);
                i += j;
                j = 1;
            } else
                j++;
        }
        resultPoints.add(segmentArr[i][1]);
        System.out.println(resultPoints.size());
        for(Integer element : resultPoints) {
            System.out.print(element + " ");
        }
    }
}
