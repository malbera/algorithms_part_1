package com.algorithms.part1.week2;

public class InsertionSort {

    static int[] sort(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(j-1, j, arr);
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
