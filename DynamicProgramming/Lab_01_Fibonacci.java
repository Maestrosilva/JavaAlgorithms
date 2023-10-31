package Algorithms.DynamicProgramming;

import java.util.Scanner;

public class Lab_01_Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(calcFib(n));
    }

    private static long calcFib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        long[] fibValues = new long[n];
        fibValues[0] = 1;
        fibValues[1] = 1;
        for (int i = 2; i < n; i++) {
            fibValues[i] = fibValues[i - 1] + fibValues[i -2];
        }
        return fibValues[n - 1];
    }
}