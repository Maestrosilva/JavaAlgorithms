package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exc_07_ConnectingCables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sequence_2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sequence_1 = IntStream.rangeClosed(1, sequence_2.length).toArray();
        int x = sequence_1.length;
        int y = sequence_2.length;
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if(sequence_1[i - 1] == sequence_2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i -1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println("Maximum pairs connected: " + dp[x][y]);
    }
}