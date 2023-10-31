package Algorithms.DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Lab_03_MoveDownRight {
    static int rows;
    static int cols;
    static int[][] matrix;
    static int[][] maxValuesMatrix;
    static Deque<String> output = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner scanners = new Scanner(System.in);
        rows = Integer.parseInt(scanners.nextLine());
        cols = Integer.parseInt(scanners.nextLine());
        matrix = new int[rows][cols];
        maxValuesMatrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanners.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            maxValuesMatrix[r] = Arrays.stream(matrix[r]).toArray();
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maxValuesMatrix[r][c] = findMaxValue(r, c);
            }
        }
        search(rows - 1, cols - 1);
        while (!output.isEmpty()){
            System.out.print(output.pop() + " ");
        }
    }

    private static void search(int r, int c) {
        output.push(String.format("[%d, %d]", r, c));
        if(r == 0 && c == 0){
            return;
        }
        int upValue = 0;
        int rightValue = 0;
        try{
            upValue = maxValuesMatrix[r - 1][c];
        }
        catch (ArrayIndexOutOfBoundsException ignored){}
        try{
            rightValue = maxValuesMatrix[r][c - 1];
        }
        catch (ArrayIndexOutOfBoundsException ignored){}

        if (rightValue >= upValue) {
            search(r, c - 1);
        } else {
            search(r - 1, c);
        }
    }

    private static int findMaxValue(int r, int c) {
        int maxValue = 0;
        if(r != 0){
            maxValue = Math.max(maxValuesMatrix[r - 1][c], maxValue);
        }
        if(c != 0){
            maxValue = Math.max(maxValuesMatrix[r][c - 1], maxValue);
        }
        return matrix[r][c] + maxValue;
    }
}