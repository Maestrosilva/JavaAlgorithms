package Algorithms.RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;

public class Lab_01_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = calcSum(numbers, 0);
        System.out.println(sum);
    }

    private static int calcSum(int[] numbers, int index) {
        if(index == numbers.length){
            return 0;
        }
        return numbers[index] + calcSum(numbers, index + 1);
    }
}