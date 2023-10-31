package Algorithms.RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exc_02_NestedLoops {
    static int[] output;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        output = new int[n];
        nestLoops(n, 0);
    }

    private static void nestLoops(int n, int index) {
        if(index == n){
            System.out.println(Arrays.stream(output)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
            return;
        }

        for (int i = 1; i <= n; i++) {
            output[index] = i;
            nestLoops(n, index + 1);
        }
    }
}