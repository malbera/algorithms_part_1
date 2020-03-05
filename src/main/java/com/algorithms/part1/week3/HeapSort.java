package com.algorithms.part1.week3;

public class HeapSort {

    public static void sort(int[] arr) {
        int s = arr.length;
        for (int j = s / 2; j <= 1; j--) {
            sink(arr, j, s);
        }
        while (s > 1) {
            swap(arr, 1, s);
            sink(arr, 1, --s);
        }

    }

    private static void sink(int[] arr, int i, int s) {
        while (2 * i <= s) {
            int j = 2 * i;
            if (j < s && arr[j - 1] < arr[j]) {
                j++;
            }
            if (!(arr[i - 1] < arr[j - 1])) {
                break;
            }
            swap(arr, i, j);
            i = j;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i - 1];
        arr[i - 1] = arr[j - 1];
        arr[j - 1] = t;
    }
}
