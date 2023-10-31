package Algorithms.EXAMS;

import java.util.*;
import java.util.stream.Collectors;

public class _02_Chainalysis {
    static Map<Character, List<Character>> data = new HashMap<>();
    static Set<Character> transactions = new LinkedHashSet<>();
    static int counter = 0;
    static Map<Character, Boolean> used = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            char[] currentTransaction = scanner.nextLine().replace(" ", "").toCharArray();
            data.putIfAbsent(currentTransaction[0], new ArrayList<>());
            data.putIfAbsent(currentTransaction[1], new ArrayList<>());
            data.get(currentTransaction[0]).add(currentTransaction[1]);
            data.get(currentTransaction[1]).add(currentTransaction[0]);
            used.putIfAbsent(currentTransaction[0], false);
            used.putIfAbsent(currentTransaction[1], false);
            transactions.add(currentTransaction[0]);
        }
        List<Character> allTransactions = transactions.stream().collect(Collectors.toList());
        for (Character tr : allTransactions) {
            if (transactions.contains(tr)) {
                exploreWholePath(tr);
                counter++;
            }
        }
        System.out.println(counter);
    }

    private static void exploreWholePath(Character tr) {
        if (used.get(tr)) {
            return;
        }
        transactions.remove(tr);
        used.put(tr, true);
        List<Character> currentTransactionData = data.get(tr);
        for (Character newTransaction : currentTransactionData) {
            exploreWholePath(newTransaction);
        }
        used.put(tr, false);
    }
}
/*
4
A B
B C
D B
B E
 */