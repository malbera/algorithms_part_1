package com.algorithms.part1.week3;

public class QuickSort {

    public static void sort(int arr[]) {
        sort(arr, 0, arr.length -1);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int p = partition(arr, lo, hi);
        sort(arr, lo, p - 1);
        sort(arr, p + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int l = lo;
        int h = hi + 1;
        while (true) {
            while (arr[++l] < arr[lo]) {
                if (l == hi) {
                    break;
                }
            }
            while (arr[lo] < arr[--h]) {
                if (h == lo) {
                    break;
                }
            }
            if (l >= h) {
                break;
            }
            swap(arr, l, h);
        }
        swap(arr, lo, h);
        return h;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
