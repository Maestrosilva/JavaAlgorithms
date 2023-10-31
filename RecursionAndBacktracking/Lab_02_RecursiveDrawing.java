package Algorithms.RecursionAndBacktracking;

import java.util.Scanner;

public class Lab_02_RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        drawUpperPart(0, n, '*');
        drawLowerPart(n + 1, 1, '#');
    }


    private static void drawUpperPart(int bottom, int n, char symbol) {
        if(n == bottom){
            return;
        }
        printRow(n, symbol);
        drawUpperPart(bottom, n - 1, symbol);
    }
    private static void drawLowerPart(int bottom, int n, char symbol) {
        if(n == bottom){
            return;
        }
        printRow(n, symbol);
        drawLowerPart(bottom, n + 1, symbol);
    }

    private static void printRow(int n, char symbol) {
        for (int i = 1; i <= n; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
/*
4

****
***
**
*
#
##
###
####
 */
