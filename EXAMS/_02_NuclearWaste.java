package Algorithms.EXAMS;

import java.util.Arrays;
import java.util.Scanner;

public class _02_NuclearWaste {
    static int[] flasks;
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        flasks = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        n = Integer.parseInt(scanner.nextLine());

        int[] minCost = new int[n + 1];
        minCost[0] = 0;

        int[] prev = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            minCost[i] = Integer.MAX_VALUE;
            prev[i] = -1;
            for (int j = 1; j <= i; j++) {
                if(j > flasks.length){
                    break;
                }
                int currentValue = minCost[i - j] + flasks[j - 1];
                if(currentValue < minCost[i]){
                    minCost[i] = currentValue;
                    prev[i] = j;
                }
            }
        }
        System.out.println("Cost: " + minCost[n]);
        int currentIndex = -1;
        while (n != 0){
            currentIndex = prev[n];
            System.out.println(currentIndex + " => " + flasks[currentIndex - 1]);
            n -= currentIndex;
        }
    }
}