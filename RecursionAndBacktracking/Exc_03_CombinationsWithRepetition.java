package Algorithms.RecursionAndBacktracking;

import java.util.*;
import java.util.stream.Collectors;


public class Exc_03_CombinationsWithRepetition {
    static int[] output;

    static Set<int[]> combs = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int k = Integer.parseInt(scanner.nextLine());

        output = new int[k];

        combs(n, k, 0);

    }

    private static void combs(int n, int k, int index) {
        if(index == k){
            if(!exists(output)) {
                combs.add(Arrays.stream(output).toArray());
                System.out.println(Arrays.stream(output)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            output[index] = i;
            combs(n, k, index + 1);
        }
    }
    private static boolean exists(int[] arr){
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        for (int[] current : combs){
            if(Arrays.equals(sortedArr, current)){
                return true;
            }
        }
        return false;
    }
}