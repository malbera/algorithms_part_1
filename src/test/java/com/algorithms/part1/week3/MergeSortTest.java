package com.algorithms.part1.week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        int[] arr = new int[] {9, 8, 7, 1, 5, 4, 3, 0};

        MergeSort.sort(arr);

        assertArrayEquals(new int[] {0, 1, 3, 4, 5, 7, 8, 9}, arr);
    }
}
