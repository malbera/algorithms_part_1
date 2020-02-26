package com.algorithms.part1.week2;

public class ShellSort {

    static int[] sort(int[] arr) {
        int n = 1;
        while (n < arr.length / 3) {
            n = n * 3 + 1;
        }

        while (n >= 1) {

            for (int i = n; i < arr.length; i++) {
                for (int j = i; j >= n && less(arr[j], arr[j - n]); j -= n) {
                    swap(j, j - n, arr);;
                }
            }

            n = n /3;
        }


        return arr;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean less(int i, int j) {
        return i < j;
    }
}
