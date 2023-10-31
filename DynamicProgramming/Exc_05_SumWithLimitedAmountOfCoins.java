package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Exc_05_SumWithLimitedAmountOfCoins {
    static int counter = 0;
    static int[] dp;
    static Set<int[]> existing = new LinkedHashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coins = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = Integer.parseInt(scanner.nextLine());
        dp = new int[target];
        findAllWays(coins, target, 0, 0, 0);
        System.out.println(counter);
    }

    private static void findAllWays(int[] coins, int target, int current, int start, int index) {
        if(current == target && !exists(dp)){
            existing.add(Arrays.stream(dp).toArray());
            counter++;
            return;
        }
        if(current > target){
            return;
        }
        for (int i = start; i < coins.length; i++) {
            dp[index] = coins[i];
            findAllWays(coins, target, current + coins[i], i + 1, index + 1);
            dp[index] = 0;
        }
    }

    private static boolean exists(int[] dp) {
        for (int[] i : existing) {
            if(Arrays.equals(i, dp)){
                return true;
            }
        }
        return false;
    }

}
//1 2 2 3 3 4 6
//6