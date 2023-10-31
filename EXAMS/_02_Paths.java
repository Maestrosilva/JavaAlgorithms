package Algorithms.EXAMS;

import java.util.*;
import java.util.stream.Collectors;

public class _02_Paths {

    static Map<Integer, List<Integer>> nodes = new LinkedHashMap<>();
    static int nodesCount;
    static ArrayDeque<Integer> currentPath;
    static Set<List<Integer>> pathsOutput = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        nodesCount = Integer.parseInt(scanner.nextLine());

        int nodeIndex = 1;
        while (nodeIndex < nodesCount){
            List<Integer> children = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            nodes.put(nodeIndex - 1, children);
            nodeIndex++;
        }

        for (Map.Entry<Integer, List<Integer>> entry : nodes.entrySet()){
            if(entry.getKey() == nodesCount - 1){
                continue;
            }
            currentPath = new ArrayDeque<>();
            int base = entry.getKey();
            findPath(base, nodesCount - 1);
        }

        pathsOutput
                .stream()
                .map(s -> s.stream()
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .sorted()
                .forEach(System.out::println);
    }

    private static void findPath(int element, Integer base) {
        currentPath.push(element);
        if(element == base){
            pathsOutput.add(currentPath.stream().collect(Collectors.toList()));
            return;
        }
        List<Integer> ways = nodes.get(element);
        for (Integer way : ways) {
            element = way;
            findPath(element, base);
            currentPath.pop();
        }
    }
}