package Algorithms.EXAMS;

import java.util.*;

public class _01_Trains {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] arrivals = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToDouble(Double::parseDouble)
                                .toArray();
        double[] departures = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        int[] dp = new int[arrivals.length + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = 1;
            double currentArrival = arrivals[i - 1];
            double currentDeparture = departures[i - 1];
            for (int j = i - 1; j >= 1 ; j--) {
                if(shouldAddAnotherPlatforms(currentArrival, currentDeparture, arrivals[j - 1], departures[j - 1])){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                else{
                    dp[i] = Math.max(1, dp[i] - 1);
                    dp[i] -= 1;
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().orElse(1));

    }

    private static boolean shouldAddAnotherPlatforms(double arr1, double dep1, double arr2, double dep2) {
        return  arr1 >= arr2 && arr1 < dep2 ||
                arr2 >= arr1 && arr2 < dep1;
        //the two trains are there at the same time
        //when one of the train's arrival is
        //between the arrival and the departure of the other one.
        //Then we need another platform.
    }
}
/*
2.00 2.10 3.00 3.20 3.50 5.00
2.30 3.40 3.20 4.30 4.00 5.20
-----------------------------
14.00 14.10 00.40 14.10 1.50
14.50 14.40 23.50 14.20 2.00
 */