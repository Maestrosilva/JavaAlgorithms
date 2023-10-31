package Algorithms.DynamicProgramming;

import java.util.*;

public class Lab_02_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = values.length;

        int[] lengths = new int[n];
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int current = values[i];
            int currentMaxLength = 1;
            int currentMaxLengthIndex = -1;
            for (int j = 0; j <= i; j++) {
                if(current > values[j] && lengths[j] >= currentMaxLength){
                    currentMaxLengthIndex = j;
                    currentMaxLength = lengths[j] + 1;
                }
            }
            lengths[i] = currentMaxLength;
            prev[i] = currentMaxLengthIndex;
        }
        int startIndex = -1;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if(lengths[i] > maxLength){
                maxLength = lengths[i];
                startIndex = i;
            }
        }
        Deque<Integer> output = new ArrayDeque<>();
        while(startIndex != -1){
            output.push(values[startIndex]);
            startIndex = prev[startIndex];
        }
        while (!output.isEmpty()){
            System.out.print(output.pop() + " ");
        }
        System.out.println();
    }
}