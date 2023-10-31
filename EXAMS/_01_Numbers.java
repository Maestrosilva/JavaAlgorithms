package Algorithms.EXAMS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Numbers {
    static Deque<Deque<Integer>> solutions = new ArrayDeque<>();
    static Deque<Integer> currentSolution = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        findCombs(n , 0, 0);
        for (Deque<Integer> solution : solutions) {
            Deque<Integer> output = new ArrayDeque<>();
            for (Integer integer : solution) {
                output.push(integer);
            }
            System.out.println(output.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" + ")));
        }
    }

    private static void findCombs(int n, int start, int currentSum) {
        if(currentSum == n){
            solutions.offer(new ArrayDeque<>(currentSolution));
            return;
        }
        for (int currentNumber = n - start; currentNumber > 0; currentNumber--) {
            if(currentNumber + currentSum > n){
                continue;
            }
            currentSolution.push(currentNumber);
            findCombs(n, n - currentNumber, currentSum + currentNumber);
            currentSolution.pop();
        }
    }
}