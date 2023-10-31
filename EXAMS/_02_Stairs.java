package Algorithms.EXAMS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _02_Stairs {
    static int n;
    static int counter = 0;
    static Deque<Integer> combs = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());

//        stairs();

        System.out.println(counter);
    }

    private static void stairs() {
        int sum = 0;
        for (Integer comb : combs) {
            sum += comb;
        }
        if(sum == n){
            counter++;
            return;
        }
        if(sum > n){
            return;
        }
        for (int i = 1; i <= 2; i++) {
            combs.push(i);
            stairs();
            combs.pop();
        }
    }
}