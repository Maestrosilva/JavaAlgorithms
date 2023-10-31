package Algorithms.EXAMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class _02_ClusterBorder {
    static int counter = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] singleShips = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] pairs = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = singleShips.length;

        int[] dp = new int[n + 1];
        int[] prev = new int[n + 1];

        dp[1] = singleShips[0];
        prev[1] = 1;

        for (int i = 2; i <= n; i++) {
            int single = singleShips[i - 1] + dp[i - 1];
            int paired = pairs[i - 2] + dp[i - 2];
            dp[i] = Math.min(single, paired);
            prev[i] = single < paired ? 1 : 2;
        }
        System.out.println("Optimal Time: " + dp[n]);
        print(n, prev, n);
    }

    private static void print(int count, int[] prev, int n) {
        if(count <= 0){
            return;
        }
        int current = prev[count];
        print(count - current, prev, n);
        if(current == 2){
            System.out.println("Pair of " + counter++ + " and " + counter++);
        }
        else{
            System.out.println("Single " + counter++);
        }
    }
}