package org.example.greedyAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * task description on https://stepik.org/lesson/13240/step/8?unit=3426
 */

public class PriorityQueueTask {

    public static void main(String[] args) {
        processQueries();
//        processTest();
    }

    static void processQueries() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();             //переход на следующую строку
        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] query = scanner.nextLine().split(" ");
            if (query.length > 1) {
                maxPriorityQueue.insert(Integer.parseInt(query[1]));
            } else {
                resultList.add(maxPriorityQueue.extractMax());
            }
        }

        for (Integer integer : resultList) {
            System.out.println(integer);
        }
    }

//    static void processTest() {
//        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue();
//        int k = 32;
//        for (int i = k; i > 0; i--) {
//            maxPriorityQueue.insert(i);
//        }
//        for (int i = 0; i < k; i++) {
//            System.out.println(maxPriorityQueue.extractMax());
//        }
//    }

    static class MaxPriorityQueue {
        private final List<Integer> values = new ArrayList<>();

        public void insert(int a) {
            values.add(a);
            siftUp(values.size() - 1);
        }

        public int extractMax() {
            int max = 0;
            if (!values.isEmpty()) {
                max = values.get(0);
                int temp = values.get(values.size()-1);
                values.remove(values.size()-1);
                if(!values.isEmpty()) {
                    values.set(0, temp);
                    siftDown(0);
                }

            }
            return max;
        }

        public void siftUp(int listIndex) {
            int treeIndex = listIndex + 1;
            while (isSiftUpNeed(treeIndex)) {
                int temp = values.get(treeIndex/2 - 1);
                values.set(treeIndex/2 - 1, values.get(treeIndex - 1));
                values.set(treeIndex - 1, temp);
                treeIndex = treeIndex/2;
            }
        }

        public void siftDown(int listIndex) {
            int treeIndex = listIndex + 1;
            while (isSiftDownNeed(treeIndex)) {
                int temp = values.get(treeIndex - 1);
                if (values.size() == treeIndex * 2) {
                    values.set(treeIndex - 1, values.get(treeIndex * 2 - 1));
                    values.set(treeIndex * 2 - 1, temp);
                    treeIndex = treeIndex * 2;
                } else {
                    if (values.get(treeIndex * 2 - 1) > values.get((treeIndex * 2))) {
                        values.set(treeIndex - 1, values.get(treeIndex * 2 - 1));
                        values.set(treeIndex * 2 - 1, temp);
                        treeIndex = treeIndex * 2;
                    } else {
                        values.set(treeIndex - 1, values.get(treeIndex * 2));
                        values.set(treeIndex * 2, temp);
                        treeIndex = treeIndex * 2 + 1;
                    }
                }
            }
        }

        private boolean isSiftUpNeed(int treeIndex) {
            if (values.size() > 1 && treeIndex > 1) {
                if (values.get(treeIndex/2 - 1) < values.get(treeIndex - 1)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isSiftDownNeed(int treeIndex) {
            if (values.size() > 1) {
                if (values.size() > treeIndex*2) {
                    if(values.get(treeIndex - 1) < values.get(treeIndex*2 - 1) || values.get(treeIndex - 1) < values.get((treeIndex*2))){
                        return true;
                    }
                    return false;
                } else if (values.size() == treeIndex*2) {
                    if (values.get(treeIndex - 1) < values.get(treeIndex*2 - 1)){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
