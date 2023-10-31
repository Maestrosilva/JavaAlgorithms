package Algorithms.RecursionAndBacktracking;

import java.util.Scanner;

public class Lab_04_RecursiveFactorial {
    static long[] memory;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n];
        long factorial = calcFactorial(n);
        System.out.println(factorial);
    }

    private static long calcFactorial(int current) {
        if(current == 1){
            memory[0] = 1;
        }
        if(memory[current - 1] == 0) {
            memory[current - 1] = current * calcFactorial(current - 1);
        }
        return memory[current - 1];
    }
}