package org.example.theoryAndPractise.FibonacciNum;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * task description on https://stepik.org/lesson/13228/step/8?unit=3414
 */


public class FibonacciNumberModM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(remnantsFibonacci(n, m));
    }

    static int remnantsFibonacci(long n, int m) {
        ArrayList<Integer> fibonacciRemnants = new ArrayList<>();
        fibonacciRemnants.add(0);
        fibonacciRemnants.add(1);
        if ( n <= 1) {
            return fibonacciRemnants.get((int)n);
        }

        else {
            int c = 0;
            boolean isBreak = false;
            for (long i = 2; i <= n; i++) {
                c = (fibonacciRemnants.get((int)i - 1) + fibonacciRemnants.get((int)i - 2)) % m;
                if ( c == 0 && fibonacciRemnants.get((int)i-1) == 1){
                    isBreak = true;
                    break;
                }
                fibonacciRemnants.add(c);
            }
            if (isBreak) {
                long a = n % fibonacciRemnants.size();
                return fibonacciRemnants.get((int)a);
            }
            else
                return fibonacciRemnants.get(fibonacciRemnants.size()-1);
        }
    }
}
