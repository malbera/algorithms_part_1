package com.algorithms.part1.week4;

import org.junit.jupiter.api.Test;

class BoardTwinTest {

    @Test
    void twin_1() {

        int[][] arr = new int[][]{
                {5, 0, 4},
                {2, 3, 8},
                {7, 1, 6},
        };


        Board board = new Board(arr);

        System.out.println(board.twin().toString());
    }
}
