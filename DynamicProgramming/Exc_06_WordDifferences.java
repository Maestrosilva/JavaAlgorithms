package Algorithms.DynamicProgramming;

import java.util.Scanner;

public class Exc_06_WordDifferences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int x = str1.length();
        int y = str2.length();

        int[][] dp = new int[x + 1][y + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= x; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= y; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        System.out.println("Deletions and Insertions: " + dp[x][y]);
    }
}