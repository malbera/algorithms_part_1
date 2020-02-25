package com.algorithms.part1.week2;

public class SelectionSort {

    static int [] sort(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[temp] > arr[j]) {
                    temp = j;
                }
            }
            swap(i, temp, arr);
        }

        return arr;
    }

    private static void swap(int i, int j, int [] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
