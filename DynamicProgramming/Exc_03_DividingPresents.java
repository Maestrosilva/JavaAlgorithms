package Algorithms.DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Exc_03_DividingPresents {
    static double minDiff = Double.MAX_VALUE;
    static Object[] output;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] prices = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = prices.length;
        double totalSum = Arrays.stream(prices).sum();

        calc(prices, totalSum / 2, 0, 0,new ArrayDeque<>());
        int value = Arrays.stream(output).mapToInt(e -> Integer.parseInt(e.toString())).sum();
        System.out.println("Difference: " + (int)(totalSum - 2 * value));
        System.out.println("Alan:" + value + " Bob:" + (int)(totalSum - value));
        System.out.println("Alan takes: " + Arrays.stream(output)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
        System.out.println("Bob takes the rest.");
    }

    private static void calc(int[] prices, double target, int current, int start, ArrayDeque<Object> objects) {
        double currentDiff = target - current;
        if(currentDiff < 0){
            return;
        }
        if(minDiff >= currentDiff){
            minDiff = currentDiff;
            output = objects.toArray();
        }
        if(minDiff == 0){
            return;
        }
        for (int i = start; i < prices.length; i++) {
            objects.push(prices[i]);
            calc(prices, target, current + prices[i], i + 1, objects);
            objects.pop();
        }
    }
}