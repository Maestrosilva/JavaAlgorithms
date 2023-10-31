package Algorithms.EXAMS;

import java.util.*;
import java.util.stream.Collectors;

public class _03_PathFinder {
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNodes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfNodes; i++) {
            List<Integer> children = new ArrayList<>();
            try {
                children = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
            }
            catch (NumberFormatException ignored){}
            graph.add(children);
        }
        int p = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < p; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            Deque<Integer> listToCheck = new ArrayDeque<>();
            for (int i1 : input) {
                listToCheck.offer(i1);
            }
            int current = listToCheck.peek();
            System.out.println(search(current, listToCheck) ? "yes" : "no");
        }
    }
    private static Boolean search(int current, Deque<Integer> list){

        List<Integer> children = graph.get(current);

        list.poll();

        if(list.isEmpty()){
            return true;
        }

        for (Integer child : children) {
            if(Objects.equals(child, list.peek())){
                return search(child, list);
            }
        }
        return false;
    }
}