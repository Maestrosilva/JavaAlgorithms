package Algorithms.RecursionAndBacktracking;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Exc_07_Cinema {
    static String[] combs;
    static String[] names;
    static Set<String> setPeople = new LinkedHashSet<>();
    static boolean[] setPositions;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        names = scanner.nextLine().split(", ");

        combs = new String[names.length];

        setPositions = new boolean[names.length];

        String[] input;
        while (!(input = scanner.nextLine().split(" - "))[0].equals("generate")){
            String name = input[0];
            int place = Integer.parseInt(input[1]);
            combs[place - 1] = name;
            setPeople.add(name);
            setPositions[place - 1] = true;
        }
        combs(names.length, 0);
    }
    private static void combs(int n, int index){
        if(n == index){
            System.out.println(String.join(" ", combs));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(setPositions[index]){
                combs(n, index + 1);
                break;
            }
            String currentName = names[i];
            if(!setPeople.contains(currentName)){
                setPeople.add(currentName);
                combs[index] = names[i];
            }
            else{
                continue;
            }
            combs(n, index + 1);
            setPeople.remove(currentName);
        }
    }
}