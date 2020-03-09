package com.algorithms.part1.week4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardHammingTest {

    @Test
    void hamming_1() {
        int[][] arr = new int[][] {{0, 1}, {2, 3}};

        Board board = new Board(arr);

        assertEquals(3, board.hamming());
    }

    @Test
    void hamming_2() {
        int[][] arr = new int[][] {{3, 0, 1}, {8, 2, 4}, {7, 6, 5}};

        Board board = new Board(arr);

        assertEquals(7, board.hamming());
    }
}
