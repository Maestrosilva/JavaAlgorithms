package Algorithms.RecursionAndBacktracking;

import java.util.*;
import java.util.stream.Collectors;

public class Lab_05_PathsInLabyrinth {
    static int rows;
    static int cols;
    static char[][] labyrinth;
    static StringBuilder output = new StringBuilder();
    static Deque<Character> path = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rows = Integer.parseInt(scanner.nextLine());
        cols = Integer.parseInt(scanner.nextLine());

        labyrinth = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            labyrinth[r] = scanner.nextLine().toCharArray();
        }
        findPath(0, 0);
        System.out.println(output.toString().trim());
    }

    private static void findPath(int row, int col) {
        if(!isInBounds(row, col)){
            return;
        }
        if(labyrinth[row][col] == 'e'){
            String current = path.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(""));
            output.append(new StringBuilder(current).reverse());
            output.append(System.lineSeparator());
            return;
        }
        if(labyrinth[row][col] != '-'){
            return;
        }
        labyrinth[row][col] = 'V';
        path.push('U');
        findPath(row - 1, col);
        path.pop();
        path.push('D');
        findPath(row + 1, col);
        path.pop();
        path.push('R');
        findPath(row, col + 1);
        path.pop();
        path.push('L');
        findPath(row, col - 1);
        path.pop();
        labyrinth[row][col] = '-';
    }
    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}