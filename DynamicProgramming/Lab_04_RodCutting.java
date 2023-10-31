package Algorithms.DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab_04_RodCutting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] prices = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int parts = Integer.parseInt(scanner.nextLine());
        int[] dp = new int[parts + 1];
        int[] prevCount = new int[parts + 1];
        for (int i = 1; i <= parts; i++) {
            dp[i] = prices[i];
            for (int j = 1; j <= i; j++) {
                int localMax = prices[j] + dp[i - j];
                if(localMax >= dp[i]){
                    dp[i] = localMax;
                    prevCount[i] = j;
                }
            }
        }
        System.out.println(dp[parts]);
        Deque<Integer> cutRopeOutput = new ArrayDeque<>();
        int currentCount;
        while((currentCount = prevCount[parts]) != 0){
            cutRopeOutput.push(currentCount);
            parts -= currentCount;
        }
        System.out.println(cutRopeOutput.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}