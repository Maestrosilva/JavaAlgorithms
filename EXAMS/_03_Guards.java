package Algorithms.EXAMS;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _03_Guards {
    static int nodes;
    static int edges;
    static boolean[] used;
    static Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
    static Set<Integer> unreached;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        nodes = Integer.parseInt(scanner.nextLine());
        edges = Integer.parseInt(scanner.nextLine());

        used = new boolean[nodes];
        unreached = IntStream.range(1, nodes + 1)
                .mapToObj(e -> Integer.parseInt(String.valueOf(e)))
                .collect(Collectors.toSet());
        for (int e = 0; e < edges; e++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int from = input[0];
            int to = input[1];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
        }
        int start = Integer.parseInt(scanner.nextLine());
        dfs(start);
        System.out.println(unreached.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static void dfs(int start) {
        if(used[start - 1]){
            return;
        }
        used[start - 1] = true;
        unreached.remove(start);
        List<Integer> children = graph.get(start);
        if(children == null){
            return;
        }
        for (Integer child : children) {
            dfs(child);
        }
    }
}