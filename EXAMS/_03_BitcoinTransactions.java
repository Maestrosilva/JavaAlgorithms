package Algorithms.EXAMS;

import java.util.*;

public class _03_BitcoinTransactions {
    static int x;
    static int y;
    static String[] arr1;
    static String[] arr2;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arr1 = scanner.nextLine().split("\\s+");
        x = arr1.length;
        arr2 = scanner.nextLine().split("\\s+");
        y = arr2.length;
        dp = new int[arr1.length  + 1][arr2.length + 1];

        for(int i=1; i <= x; i++){
            for(int j=1; j<=y; j++){
                if(arr1[i - 1].equals(arr2[j - 1])){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int count = dp[x][y];
        Deque<String> longestSubsequence = new ArrayDeque<>();
        int index = findRow(count, x);
        longestSubsequence.push(arr1[index - 1]);
        while (--count != 0) {
            index = findRow(count, index - 1);
            longestSubsequence.push(arr1[index - 1]);
        }
        System.out.printf("[%s]", String.join(" ", longestSubsequence));
        System.out.println();
    }

    private static int findRow(int count, int r) {
        if (r == -1 || dp[r][y] < count) {
            return r + 1;
        }
        return findRow(count, r - 1);
    }
}