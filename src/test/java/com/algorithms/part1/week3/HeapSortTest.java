package com.algorithms.part1.week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    void sort() {
        int[] arr = new int[] {8, 5, 2, 6, 1, 3, 4};

        QuickSort.sort(arr);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 8}, arr);
    }
}
