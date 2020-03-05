package com.algorithms.part1.week3;

public class ThreeWayQuickSort {

    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int l = lo;
        int h = hi;
        int comp = arr[l];
        int i = lo;
        while (l <= h) {
            if (arr[i] < comp) {
                swap(arr, l++, i++);
            } else if (arr[i] > comp) {
                swap(arr, i, h--);
            } else {
                i++;
            }
        }
        sort(arr, lo, l - 1);
        sort(arr, h + 1, hi);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
