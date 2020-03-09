package com.algorithms.part1.week4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardManhattanTest {

    @Test
    void manhattan_1() {
        int[][] arr = new int[][] {
                {0, 1, 3},
                {4, 2, 5},
                {7, 8, 6}
        };

        Board board = new Board(arr);

        assertEquals(4, board.manhattan());
    }

    @Test
    void manhattan_2() {
        int[][] arr = new int[][] {
                {1, 2, 3},
                {0, 7, 6},
                {5, 4, 8}
        };

        Board board = new Board(arr);

        assertEquals(7, board.manhattan());
    }

    @Test
    void manhattan_3() {
        int[][] arr = new int[][] {
                {5, 8, 7},
                {1, 4, 6},
                {3, 0, 2}
        };

        Board board = new Board(arr);

        assertEquals(17, board.manhattan());
    }
}
