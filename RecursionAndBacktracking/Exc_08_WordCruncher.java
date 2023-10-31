package Algorithms.RecursionAndBacktracking;

import java.util.*;
import java.util.stream.Collectors;

public class Exc_08_WordCruncher {
    static String[] words;
    static String[] crunchedWords;
    static String finalString;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        words = scanner.nextLine().split(", ");

        finalString = scanner.nextLine();

        used = new boolean[words.length];

        crunchedWords = new String[words.length];

        combs(words.length, 0, 0);

    }

    private static void combs(int length, int index, int finalStringIndex) {
        if(index == length || finalStringIndex == finalString.length()){
            if(finalString.equals(toString(crunchedWords))){
                System.out.println(Arrays.stream(crunchedWords)
                        .filter(Objects::nonNull)
                        .collect(Collectors.joining(" ")));
            }
            return;
        }
        for (int i = length - 1; i >= 0; i--) {
            String currentString = words[i];
            if(currentString.length() + finalStringIndex > finalString.length()
                    || currentString.charAt(0) != finalString.charAt(finalStringIndex)
            || used[i]){
                continue;
            }
            used[i] = true;
            crunchedWords[index] = currentString;
            combs(length, index + 1, finalStringIndex + currentString.length());
            crunchedWords[index] = null;
            used[i] = false;
        }
    }

    private static String toString(String[] arr) {
        StringBuilder output = new StringBuilder();

        for (String s : arr) {
            if(s != null) {
                output.append(s);
            }
        }
        return output.toString().trim();
    }
}
/*
sof, s, uni, i, ni, t, tu, soft, uni, softuni, softun, oft
softuni:

softun i
softuni
soft uni
soft uni
s oft uni
s oft uni
sof tu ni
sof t uni
sof t uni
 */