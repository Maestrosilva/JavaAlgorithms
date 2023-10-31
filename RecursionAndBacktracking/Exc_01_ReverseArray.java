package Algorithms.RecursionAndBacktracking;

import java.util.Scanner;

public class Exc_01_ReverseArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        reverse(input, 0);
    }

    private static void reverse(String[] input, int index) {
        if(index == input.length){
            return;
        }
        reverse(input, index + 1);
        System.out.print(input[index] + " ");
    }
}