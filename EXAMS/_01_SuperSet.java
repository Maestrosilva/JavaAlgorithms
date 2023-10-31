package Algorithms.EXAMS;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_SuperSet {
    static int[] elements;

    static int[] superSets;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
//        long time = System.currentTimeMillis();
        for (int length = 1; length <= elements.length; length++) {
            superSets = new int[length];
            combs(0, 0, length);
        }
//        System.out.println();
//        System.out.println(System.currentTimeMillis() - time);
    }

    private static void combs(int start, int index, int length) {
        if(index == length){
            System.out.println(Arrays.stream(superSets)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
            return;
        }
        for (int i = start; i < elements.length; i++) {
            superSets[index] = elements[i];
            combs(i + 1, index + 1, length);
        }
    }
}