package Algorithms.DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Exc_02_LongestZigZagSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] dp = new int[2][numbers.length];
        dp[0][0] = 1;
        dp[1][0] = 1;
        int[][] prev = new int[2][numbers.length];
        prev[0][0] = -1;
        prev[1][0] = -1;
        int bestIndex = -1;
        int bestLength = 0;
        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int currentGreaterMaxLength = 0;
            int currentLowerMaxLength = 0;
            for (int j = i; j >= 0; j--) {
                if(current > numbers[j] && currentGreaterMaxLength <= dp[1][j] + 1){
                    currentGreaterMaxLength = dp[1][j] + 1;
                    prev[0][i] = j;
                }
                if(current < numbers[j] && currentLowerMaxLength <= dp[0][j] + 1){
                    currentLowerMaxLength = dp[0][j] + 1;
                    prev[1][i] = j;
                }
            }
            dp[0][i] = currentGreaterMaxLength;
            dp[1][i] = currentLowerMaxLength;
            if(Math.max(currentGreaterMaxLength , currentLowerMaxLength) > bestLength){
                bestIndex = i;
            }
            bestLength = Math.max(bestLength, Math.max(currentGreaterMaxLength, currentLowerMaxLength));
        }
        int switcher = dp[0][numbers.length - 1] > dp[1][numbers.length - 1] ? 0 : 1;
        int index = bestIndex;
        Deque<Integer> output = new ArrayDeque<>();
        int counter = switcher;
        while (index != -1){
            output.push(numbers[index]);
            counter++;
            index = prev[switcher][index];
            switcher = counter % 2;
        }
        while (!output.isEmpty()){
            System.out.print(output.pop() + " ");
        }
    }
}
