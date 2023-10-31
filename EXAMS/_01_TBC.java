package Algorithms.EXAMS;

import java.util.Scanner;

public class _01_TBC {
    static char[][] matrix;
    static int rows;
    static int cols;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rows = Integer.parseInt(scanner.nextLine());
        cols = Integer.parseInt(scanner.nextLine());

        matrix = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
        }

        int tunnelsCounter = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(matrix[r][c] == 't'){
                    findTunnel(r, c);
                    tunnelsCounter++;
                }
            }
        }
        System.out.println(tunnelsCounter);
    }

    private static void findTunnel(int row, int col) {

        matrix[row][col] = '*';
        checker(row - 1, col);
        checker(row + 1, col);
        checker(row, col - 1);
        checker(row, col + 1);
        checker(row - 1, col - 1);
        checker(row - 1, col + 1);
        checker(row + 1, col - 1);
        checker(row + 1, col + 1);

    }
    private static void checker(int row, int col) {
        try {
            if(matrix[row][col] == 't'){
                findTunnel(row, col);
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored){}
    }
}