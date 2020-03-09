package com.algorithms.part1.week4;

import org.junit.jupiter.api.Test;

class BoardToStringTest {

    @Test
    void toString_1() {
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0},

        };

        Board board = new Board(arr);

        System.out.println(board.toString());
    }

    @Test
    void toString_2() {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
        };

        Board board = new Board(arr);

        System.out.println(board.toString());
    }

    @Test
    void toString_3() {
        int[][] arr = new int[][]{
                {1, 2},
                {3, 0},
        };

        Board board = new Board(arr);

        System.out.println(board.toString());
    }
}
