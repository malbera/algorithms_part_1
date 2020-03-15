package com.algorithms.part1.week4;

public class BinarySearch {

    public static int search(int[] arr, int key) {
        int l = 0;
        int h = arr.length;
        while (l <= h) {
            int mid = (h + l) >>> 1;
            if (arr[mid] > key) {
                h = mid - 1;
            } else if (arr[mid] < key) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
