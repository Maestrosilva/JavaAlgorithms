package Algorithms.EXAMS;

import java.util.*;
import java.util.stream.Collectors;

public class _01_MonkeyBusiness {
    static int n;
    static int[] combs;
    static int combCounter = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());

        combs = new int[n];

        findCombinations(1);

        System.out.println("Total Solutions: " + combCounter);
    }

    private static void findCombinations(int currentCount) {
        if(currentCount > n){
            if(Arrays.stream(combs).sum() == 0){
                print(combs);
                combCounter++;
            }
            return;
        }
        combs[currentCount - 1] = currentCount;
        findCombinations(currentCount + 1);
        combs[currentCount - 1] = -currentCount;
        findCombinations(currentCount + 1);
    }

    private static void print(int[] current) {
        System.out.println(Arrays.stream(current)
                .mapToObj(e -> e < 0 ? String.valueOf(e) : "+" + e)
                .collect(Collectors.joining(" ")));
    }
}