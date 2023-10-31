package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Exc_04_SumWithUnlimitedAmountOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coins = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = Integer.parseInt(scanner.nextLine());
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int current : coins) {
            for (int j = current; j <= target; j++) {
                dp[j] += dp[j - current];
            }
        }
        System.out.println(dp[target]);
    }
}
