package com.algorithms.part1.week4;

import edu.princeton.cs.algs4.MinPQ;

import java.util.Stack;

public class Solver {

    private boolean solvable;
    private PathFinder solution;

    public Solver(Board initial) {

        if (initial == null) {
            throw new IllegalArgumentException();
        }

        MinPQ<PathFinder> initPQ = new MinPQ<>();
        MinPQ<PathFinder> twinPQ = new MinPQ<>();
        initPQ.insert(new PathFinder(initial, 0, null));
        twinPQ.insert(new PathFinder(initial.twin(), 0, null));

        while (true) {

            PathFinder min = initPQ.delMin();
            PathFinder twinMin = twinPQ.delMin();

            if (min.board.isGoal()) {
                solvable = true;
                solution = min;
                break;
            }
            if (twinMin.board.isGoal()) {
                solvable = false;
                solution = twinMin;
                break;
            }

            addNeighborsToQueue(min, initPQ);
            addNeighborsToQueue(twinMin, twinPQ);
        }

    }

    private void addNeighborsToQueue(PathFinder path, MinPQ<PathFinder> queue) {
        for (Board neighbor : path.board.neighbors()) {
            if (path.previous == null || !path.previous.board.equals(neighbor)) {
                queue.insert(new PathFinder(neighbor, path.moves + 1, path));
            }
        }

    }

    public boolean isSolvable() {
        return solvable;
    }

    public int moves() {
        return solvable ? solution.moves : -1;
    }

    public Iterable<Board> solution() {

        if (!solvable) {
            return null;
        }

        PathFinder temp = solution;
        Stack<Board> sequence = new Stack<>();
        while (temp != null) {
            sequence.push(temp.board);
            temp = temp.previous;
        }

        return sequence;

    }

    private class PathFinder implements Comparable<PathFinder> {

        private PathFinder previous;
        private Board board;
        private int moves;

        private PathFinder(Board board, int moves, PathFinder previous) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
        }

        private int cost() {
            return board.manhattan() + moves;
        }

        @Override
        public int compareTo(PathFinder o) {
            int thisCost = cost();
            int thatCost = o.cost();
            if (thisCost > thatCost) {
                return 1;
            } else if (thisCost < thatCost) {
                return -1;
            }
            return 0;
        }
    }


}
