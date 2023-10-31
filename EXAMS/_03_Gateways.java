package Algorithms.EXAMS;

import java.util.*;
import java.util.stream.Collectors;

public class _03_Gateways {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Deque<Integer> currentPath = new ArrayDeque<>();
    static Deque<Integer> shortestPath = new ArrayDeque<>();
    static Set<Integer> visited = new LinkedHashSet<>();
    static int minDistance = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = Integer.parseInt(scanner.nextLine());
        int connections = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < connections; i++) {
            int[] nodeConnection = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int from = nodeConnection[0];
            int[] to = Arrays.copyOfRange(nodeConnection, 1, nodeConnection.length);
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).addAll(Arrays.stream(to).boxed().collect(Collectors.toList()));
        }
        int start = Integer.parseInt(scanner.nextLine());
        int target = Integer.parseInt(scanner.nextLine());
        dps(start, target);
        System.out.println(shortestPath.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static void dps(int currentNode, int target) {
        if(visited.contains(currentNode)){
            return;
        }
        currentPath.push(currentNode);
        visited.add(currentNode);
        if(currentNode == target){
            if(currentPath.size() < minDistance){
                shortestPath.clear();
                minDistance = currentPath.size();
                for (Integer n : currentPath) {
                    shortestPath.push(n);
                }
            }
            visited.remove(currentPath.pop());
            return;
        }
        List<Integer> paths = graph.get(currentNode);
        if(paths == null){
            visited.remove(currentPath.pop());
            return;
        }
        for (Integer n : paths) {
            dps(n, target);
        }
        visited.remove(currentPath.pop());
    }
}
/*
30
30
1 2
2 3
4 5
5 7
9 9
1 3
4 6
3 4
4 9
1 9
9 1
2 8
3 5
6 10
10 13
12 17
15 13
13 15
22 21
25 26
29 25
26 27
1 30
3 27
27 16
16 11
11 20
20 24
24 20
24 23
1
23
 */