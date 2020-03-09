package com.algorithms.part1.week4;

import edu.princeton.cs.algs4.MinPQ;

import java.util.Iterator;

public class Solver {

    private MinPQ<Board> boards;

    public Solver(Board initial) {
        this.boards = new MinPQ<>();
        this.boards.insert(initial);
        initial.manhattan();
    }

    public boolean isSolvable() {
        return false;
    }

    public int moves() {
        return 0;
    }

    public Iterable<Board> solution() {
        return () -> null;
    }


}
