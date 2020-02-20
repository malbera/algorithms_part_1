package com.algorithms.part1.week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int[][] MOVES = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private final int n;
    private final WeightedQuickUnionUF unionUF;
    private final boolean[] openSites;
    private int openSitesCount = 0;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        int gridSize = n * n;
        unionUF = new WeightedQuickUnionUF(gridSize + 2);
        openSites = new boolean[gridSize];
    }

    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            int position = getPosition(row, col);
            openSites[position] = true;
            openSitesCount++;
            for (int[] move : MOVES) {
                int r = row + move[0];
                int c = col + move[1];
                int pos = getPosition(r, c);
                if (isValidCornerCase(r) && isValidCornerCase(c) && isValid(pos) && openSites[pos]) {
                    unionUF.union(position, pos);
                }
            }
            if (row == 1) {
                unionUF.union(position, n * n);
            }
            if (row == n) {
                unionUF.union(position, n * n + 1);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        int position = getPosition(row, col);
        if (isValid(position)) {
            return openSites[position];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isFull(int row, int col) {
        int position = getPosition(row, col);
        if (isValid(position)) {
            return unionUF.find(position) == unionUF.find(n * n);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int numberOfOpenSites() {
        return openSitesCount;
    }

    public boolean percolates() {
        return unionUF.find(n * n) == unionUF.find(n * n + 1);
    }

    private int getPosition(int row, int col) {
        return (row - 1) * n + col - 1;
    }

    private boolean isValid(int n) {
        return n >= 0 && n < this.n * this.n;
    }

    private boolean isValidCornerCase(int r) {
        return r > 0 && r <= n;
    }


}
