package com.algorithms.part1.week4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void search() {
        int[] arr = new int[] {1, 2, 3, 4, 5};

        int result = BinarySearch.search(arr, 5);

        assertEquals(4, result);
    }
}
