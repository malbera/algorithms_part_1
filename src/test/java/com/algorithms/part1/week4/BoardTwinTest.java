package com.algorithms.part1.week4;

import org.junit.jupiter.api.Test;

class BoardTwinTest {

    @Test
    void twin_1() {

        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {8, 7, 0},
        };


        Board board = new Board(arr);

        System.out.println(board.twin().toString());
    }
}
