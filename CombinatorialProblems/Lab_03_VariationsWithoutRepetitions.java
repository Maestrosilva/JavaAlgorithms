package Algorithms.CombinatorialProblems;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab_03_VariationsWithoutRepetitions {
    static String[] elements;
    static String[] combs;
    //    static boolean[] used;
    static int k;
    static int n;
//    static Set<String[]> exist = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        k = Integer.parseInt(scanner.nextLine());

        n = elements.length;

        combs = new String[k];

//        used = new boolean[n];

        combs(0);
    }

    private static void combs(int index) {
        if (index == k) {
//            if(!exists(combs)) {
//                exist.add(Arrays.copyOf(combs, k));
            System.out.println(String.join(" ", combs));
//            }
            return;
        }
        for (int i = 0; i < n; i++) {
//            if(!used[i]){
//                used[i] = true;
            combs[index] = elements[i];
            combs(index + 1);
//                used[i] = false;
        }
    }

//    private static boolean exists(String[] combs) {
//        for (String[] e : exist) {
//            if(Arrays.equals(e, combs)){
//                return true;
//            }
//        }
//        return false;
//    }
}