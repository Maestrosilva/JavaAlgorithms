package Algorithms.EXAMS;

import java.util.Scanner;

public class _01_BitcoinMiners {
    static int n;
    static int x;
    static int counter = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        x = Integer.parseInt(scanner.nextLine());
        solution(0, 1);
        System.out.println(counter);
    }

    private static void solution(int index, int start) {
        if(index == x){
            counter++;
            return;
        }
        for (int i = start; i <= n; i++) {
            solution(index + 1, i  + 1);
        }
    }
}