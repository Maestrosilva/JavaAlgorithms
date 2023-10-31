package Algorithms.RecursionAndBacktracking;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class Exc_06_ConnectedAreasInMatrix {
    static char[][] matrix;
    static int rows;
    static int cols;

    static Map<int[], Integer> areaInfo = new LinkedHashMap<>();
    static int area;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        rows = Integer.parseInt(scanner.nextLine());
        cols = Integer.parseInt(scanner.nextLine());

        matrix = new char[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        findAreas();

        System.out.println("Total areas found: " + areaInfo.size());

        AtomicInteger counter = new AtomicInteger(1);

        Function<Map.Entry<int[], Integer>, String> outputFormat = e
                -> String.format("Area #%d at (%d, %d), size: %d"
                , counter.getAndIncrement(), e.getKey()[0], e.getKey()[1], e.getValue());

        areaInfo.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> e.getKey()[1]))
                .sorted(Comparator.comparingInt(e -> e.getKey()[0]))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(outputFormat)
                .forEach(System.out::println);

        System.out.println();
    }
    private static void findAreas(){
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(matrix[r][c] == '-'){
                    area = 0;
                    calculateArea(r, c);
                    areaInfo.put(new int[]{r, c}, area);
                }
            }
        }
    }

    private static void calculateArea(int r, int c) {
        if(r >= rows || c >= cols || r < 0 || c < 0){
            return;
        }
        if(matrix[r][c] == '*' || matrix[r][c] == 'V'){
            return;
        }
        matrix[r][c] = 'V';
        area++;

        calculateArea(r + 1, c);
        calculateArea(r - 1, c);
        calculateArea(r, c + 1);
        calculateArea(r, c - 1);
    }
}