package Algorithms.EXAMS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _02_Socks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence_1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sequence_2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] lengths = new int[sequence_1.length + 1][sequence_2.length + 1];
        for (int i = 0; i < sequence_1.length; i++) {
            Arrays.fill(lengths[i], 0);
        }
        for (int i = 0; i < sequence_1.length; i++) {
            for (int j = 0; j < sequence_2.length; j++) {
                    if (sequence_1[i] == sequence_2[j]) {
                        lengths[i + 1][j + 1] = 1 + lengths[i][j];
                    }
                    else{
                        lengths[i + 1][j + 1] = Math.max(lengths[i][j + 1], lengths[i + 1][j]);
                    }
            }
        }
        System.out.println(Arrays.stream(lengths)
                .map(e -> Arrays.stream(e).max().getAsInt())
                .max(Comparator.naturalOrder())
                .orElse(0));
    }
}