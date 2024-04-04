//Q1: Merge two arrays by satisfying given constraints
//        Given two sorted arrays X[] and Y[] of size m and n each where m >= n and X[] has exactly n vacant cells,
//        merge elements of Y[] in their correct position in array X[], i.e., merge (X, Y) by keeping the sorted order.
//
//        For example,
//
//        Input: X[] = { 0, 2, 0, 3, 0, 5, 6, 0, 0 }
//        Y[] = { 1, 8, 9, 10, 15 } The vacant cells in X[] is represented by 0
//        Output: X[] = { 1, 2, 3, 5, 6, 8, 9, 10, 15 }

import java.util.*;
    public class Question_No_1 {
        public static void merge(int[] X, int[] Y) {
            int m = X.length;
            int n = Y.length;

            int k = 0;
            for (int i = 0; i < m; i++) {
                if (X[i] != 0) {
                    X[k++] = X[i];
                }
            }

            int i = k - 1;
            int j = n - 1;
            k = m - 1;

            while (i >= 0 && j >= 0) {
                if (X[i] > Y[j]) {
                    X[k--] = X[i--];
                } else {
                    X[k--] = Y[j--];
                }
            }

            while (j >= 0) {
                X[k--] = Y[j--];
            }
        }

        public static void main(String[] args) {
            int[] X = {0, 2, 0, 3, 0, 5, 6, 0, 0};
            int[] Y = {1, 8, 9, 10, 15};
            merge(X, Y);


            for (int i = 0; i < X.length; i++) {
                System.out.print(X[i] + " ");
            }
        }
    }


