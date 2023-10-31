package Algorithms.RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab_03_Generating_0_1_Vectors {
    static int[] vector;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        vector = new int[n];
        generateVectors(0, n);
    }

    private static void generateVectors(int index, int n) {
        if(n == index){
            System.out.println(Arrays.stream(vector)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("")));
            return;
        }
        for (int i = 0; i <= 1; i++) {
            vector[index] = i;
            generateVectors(index + 1, n);
        }
    }
}
/*
3

0 0 0
0 0 1
0 1 0
0 1 1
1 0 0
1 0 1
1 1 0
1 1 1
 */