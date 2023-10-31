package Algorithms.EXAMS;

import java.util.Arrays;
import java.util.Scanner;

public class _02_TheTyrant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] dp = new int[sequence.length + 1];
        for (int i = 1; i <= sequence.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= Math.max(i - 4, 0); j--) {
                int localMin = sequence[i - 1] + dp[j];
                if(localMin < dp[i]){
                    dp[i] = localMin;
                }
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = dp.length - 1; i >= Math.max(dp.length - 4, 0) ; i--) {
            if(dp[i] < minSum){
                minSum = dp[i];
            }
        }
        System.out.println(minSum);
    }
}