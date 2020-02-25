package com.algorithms.part1.week2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void sort() {
        int[] arr = {7, 10, 5, 3, 11, 1};

        InsertionSort.sort(arr);

        assertArrayEquals(new int[]{1, 3, 5, 7, 10, 11}, arr);
    }
}
