package Algorithms.CombinatorialProblems;

import java.util.Scanner;

public class Lab_01_PermutationsWithoutRepetitions {
    static String[] elements;

    static String[] combs;

    static boolean[] used;

    static int n;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().replace(" ", "").split("");

        n = elements.length;

        combs = new String[n];

        used = new boolean[n];
        
        combs(0);

    }

    private static void combs(int index) {
        if(index == n){
            System.out.println(String.join(" ", combs));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!used[i]) {
                used[i] = true;
                combs[index] = elements[i];
                combs(index + 1);
                used[i] = false;
            }
        }
    }
}