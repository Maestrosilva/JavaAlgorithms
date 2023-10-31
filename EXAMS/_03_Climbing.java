package Algorithms.EXAMS;


import java.util.Arrays;
import java.util.Scanner;

public class _03_Climbing {

    static int[][] matrix;
    static int[][] maxValuesMatrix;
    static int rows;
    static int cols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        rows = Integer.parseInt(scanner.nextLine());
        cols = Integer.parseInt(scanner.nextLine());
        matrix = new int[rows][cols];
        maxValuesMatrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            int[] row = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[r] = Arrays.stream(row).toArray();
            maxValuesMatrix[r] = Arrays.stream(row).toArray();
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maxValuesMatrix[r][c] = findMax(r, c);
                if(r == 0 && c == 0){
                    maxValuesMatrix[r][c] = matrix[r][c];
                }
            }
        }
        System.out.println(maxValuesMatrix[rows - 1][cols - 1]);
        search(rows - 1, cols - 1);
    }
    private static int findMax(int r, int c) {
        int from = Integer.MIN_VALUE;
        if(r != 0){
            from = Math.max(maxValuesMatrix[r - 1][c], from);
        }
        if(c != 0){
            from = Math.max(maxValuesMatrix[r][c - 1], from);
        }
        return matrix[r][c] + from;
    }

    private static void search(int r, int c){
        System.out.print(matrix[r][c] + " ");
        if(r == 0 && c == 0){
            return;
        }
        int up = 0;
        int left = 0;
        try {
            up = maxValuesMatrix[r - 1][c];
        }
        catch (ArrayIndexOutOfBoundsException ignored){
        }
        try {
            left = maxValuesMatrix[r][c - 1];
        }
        catch (ArrayIndexOutOfBoundsException ignored){
        }

        if(up > left){
            search(r - 1, c);
        }
        else {
            search(r, c - 1);
        }
    }
}