package com.algorithms.part1.week2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void sort() {
        int [] arr = {9, 8, 7, 6, 5};
        SelectionSort.sort(arr);

        assertArrayEquals(new int[]{5, 6, 7, 8, 9}, arr);
    }
}
