// Q2:Find maximum sum path involving elements of given arrays
// Given two sorted arrays of integers, find a maximum sum path involving elements of both arrays whose sum is maximum. 
// We can start from either array, but we can switch between arrays only through its common elements.

// For example,

// Input: X = { 3, 6, 7, 8, 10, 12, 15, 18, 100 }
// Y = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 }  
// The maximum sum path is: 1 —> 2 —> 3 —> 6 —> 7 —> 9 —> 10 —> 12 —> 15 —> 16 —> 18 —> 100 
// The maximum sum is 199

import java.util.ArrayList;
import java.util.List;

public class Question_No_2 {
    public static void maxSumPath(int[] X, int[] Y) {
        int sumX = 0, sumY = 0;
        int m = X.length, n = Y.length;
        int i = 0, j = 0;

        List<Integer> pathX = new ArrayList<>();
        List<Integer> pathY = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        while (i < m && j < n) {
            if (X[i] < Y[j]) {
                sumX += X[i];
                pathX.add(X[i]);
                i++;
            } else if (X[i] > Y[j]) {
                sumY += Y[j];
                pathY.add(Y[j]);
                j++;
            } else {
                if (sumX > sumY) {
                    result.addAll(pathX);
                } else {
                    result.addAll(pathY);
                }
                pathX.clear();
                pathY.clear();
                sumX = sumY = 0;
                result.add(X[i]);
                i++;
                j++;
            }
        }

        while (i < m) {
            sumX += X[i];
            pathX.add(X[i]);
            i++;
        }

        while (j < n) {
            sumY += Y[j];
            pathY.add(Y[j]);
            j++;
        }

        if (sumX >= sumY) {
            result.addAll(pathX);
        } else {
            result.addAll(pathY);
        }

        System.out.println("The maximum sum path is: " + String.join(" —> ", result.stream().map(String::valueOf).toArray(String[]::new)));
        System.out.println("The maximum sum is " + result.stream().mapToInt(Integer::intValue).sum());
    }

    public static void main(String[] args) {
        int[] X = { 3, 6, 7, 8, 10, 12, 15, 18, 100 };
        int[] Y = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 };

        maxSumPath(X, Y);
    }
}
