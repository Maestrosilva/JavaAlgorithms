package Algorithms.RecursionAndBacktracking;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exc_04_TowerOfHanoi {

    static Deque<Integer> source = new ArrayDeque<>();
    static Deque<Integer> destination = new ArrayDeque<>();
    static Deque<Integer> spare = new ArrayDeque<>();
    static int steps = 0;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int discs = Integer.parseInt(scanner.nextLine());

        solve(discs);

    }

    private static void solve(int disks) {

        for (int i = disks; i > 0; i--) {
            source.push(i);
        }

        generateRods();

        towerOfHanoi(disks, source, spare, destination);

        System.out.println(output);
    }

    private static void towerOfHanoi(int disks, Deque<Integer> source, Deque<Integer> spare, Deque<Integer> destination) {
        if (disks == 1) {
            destination.push(source.pop());
            generateOutput();
        }
        else {
            towerOfHanoi(disks - 1, source, destination, spare);
            towerOfHanoi(1, source, spare, destination);
            towerOfHanoi(disks - 1, spare, source, destination);
        }
    }
    private static void generateOutput() {
        output.append(String.format("Step #%d: Moved disk", ++steps));
        output.append(System.lineSeparator());
        generateRods();
    }

    private static void generateRods() {
        output.append("Source: ").append(rod(source));
        output.append("Destination: ").append(rod(destination));
        output.append("Spare: ").append(rod(spare));
        output.append(System.lineSeparator());
    }

    private static String rod(Deque<Integer> stack) {
        StringBuilder rod = new StringBuilder();
        rod.append(stack.stream()
                .sorted(Comparator.reverseOrder())
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
        rod.append(System.lineSeparator());
        return rod.toString();
    }
}