package Algorithms.CombinatorialProblems;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab_07_N_Choose_K_Count {
    static int n;
    static int k;
    static int[] combs;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());

        k = Integer.parseInt(scanner.nextLine());

        combs = new int[k];
//        long time = System.currentTimeMillis();
        calculateCombCount(0, 1);

        System.out.println(count);
//        System.out.println(System.currentTimeMillis() - time);
    }

    private static void calculateCombCount(int index, int start) {
        if(index == k){
            count++;
            return;
        }
        for (int i = start; i <= n; i++) {
            combs[index] = i;
            calculateCombCount(index + 1, i + 1);
        }
    }
}