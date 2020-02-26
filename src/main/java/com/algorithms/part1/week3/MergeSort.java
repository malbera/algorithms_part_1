package com.algorithms.part1.week3;

public class MergeSort {

    public static void sort(int[] arr) {
        sort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static void sort(int[] arr,
                             int[] aux,
                             int lo,
                             int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = (lo + hi) >>> 1;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    private static void merge(int[] arr,
                       int[] aux,
                       int lo,
                       int mid,
                       int hi) {

        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }

        int l = lo;
        int h = mid + 1;

        for (int i = lo; i <= hi; i++) {
            if (l > mid) {
                arr[i] = aux[h++];
            } else if (h > hi) {
                arr[i] = aux[l++];
            } else if (aux[h] < aux[l]) {
                arr[i] = aux[h++];
            } else {
                arr[i] = aux[l++];
            }
        }

    }

}
