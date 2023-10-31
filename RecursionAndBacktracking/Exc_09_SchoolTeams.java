package Algorithms.RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exc_09_SchoolTeams {
    static String[] girlNames;
    static String[] boyNames;
    static String[] teams = new String[5];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        girlNames = scanner.nextLine().split(", ");
        boyNames = scanner.nextLine().split(", ");
        generateGirls(0, 0);
    }

    private static void generateGirls(int index, int start) {
        if(index == 3){
            generateBoys(3, 0);
            return;
        }
        for (int i = start; i < girlNames.length; i++) {
            String currentGirlName = girlNames[i];
            teams[index] = currentGirlName;
            generateGirls(index + 1, i + 1);
        }
    }

    private static void generateBoys(int index, int start) {
        if(index == 5){
            System.out.println(String.join(", ", teams));
            return;
        }
        for (int i = start; i < boyNames.length; i++) {
            String currentBoyName = boyNames[i];
            teams[index] = currentBoyName;
            generateBoys(index + 1, i + 1);
        }
    }
}