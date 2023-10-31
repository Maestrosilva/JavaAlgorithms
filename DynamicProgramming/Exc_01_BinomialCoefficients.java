package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Exc_01_BinomialCoefficients {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());
        long[][] matrix = new long[row + 1][];
        for (int r = 0; r <= row; r++) {
            long[] currentRow = new long[r + 1];
            Arrays.fill(currentRow, 1);
            matrix[r] = currentRow;
        }
        for (int r = 2; r <= row; r++) {
            for (int c = 1; c <= r - 1; c++) {
                matrix[r][c] = matrix[r - 1][c] + matrix[r - 1][c - 1];
            }
        }
        System.out.println(matrix[row][col]);
    }
}
/*
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
1 6 15 20 15 6 1
 */