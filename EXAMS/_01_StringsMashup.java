package Algorithms.EXAMS;

import java.util.*;

public class _01_StringsMashup {
    static String[] elements;
    static String[] current;
    static int n;
    static int k;
    static List<String[]> existing = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("");

        Arrays.sort(elements);

        n = elements.length;

        k = Integer.parseInt(scanner.nextLine());

        current = new String[k];

        printCombs(0);
    }

    private static void printCombs(int index) {
        if(index == k){
            if(!exists(Arrays.stream(current).sorted().toArray(String[]::new))) {
                existing.add(Arrays.stream(current).sorted().toArray(String[]::new));
                System.out.println(String.join("", current));
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            current[index] = elements[i];
            printCombs(index + 1);
        }
    }

    private static boolean exists(String[] str) {
        for (String[] stringStream : existing) {
            if(Arrays.equals(stringStream, str)){
                return true;
            }
        }
        return false;
    }
}