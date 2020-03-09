package com.algorithms.part1.week4;

import java.util.Arrays;

public class Board {

    private int[][] tiles;
    private int[][] goal;

    public Board(int[][] tiles) {
        int inc = 1;
        int limit = tiles.length * tiles.length;
        int[][] goal = new int[tiles.length][tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length && inc < limit; j++) {
                goal[i][j] = inc++;
            }
        }
        this.goal = goal;
        this.tiles = tiles.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dimension());
        sb.append(System.lineSeparator());
        for (int[] tile : tiles) {
            for (int i : tile) {
                sb.append(String.format("%2d ", i));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int dimension() {
        return tiles.length;
    }

    public int hamming() {
        int result = 0;
        int inc = 1;
        int lim = tiles.length * tiles.length;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length && inc < lim; j++) {
                if (tiles[i][j] != inc++) {
                    result++;
                }
            }
        }
        return result;
    }

    public int manhattan() {
        int result = 0;
        int inc = 1;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] != 0) {
                    result += manhattan(inc, tiles[i][j]);
                }
                inc++;
            }
        }
        return result;
    }

    private int manhattan(int v1, int v2) {
        int x0, x1, y0, y1;
        int t = v1 % dimension();
        if (t == 0) {
            x0 = dimension();
            y0 = v1 / dimension();
        } else {
            x0 = t;
            y0 = v1 / dimension() + 1;
        }
        t = v2 % dimension();
        if (t == 0) {
            x1 = dimension();
            y1 = v2 / dimension();
        } else {
            x1 = t;
            y1 = v2 / dimension() + 1;
        }
        int t0 = x0 - x1;
        int t1 = y0 - y1;
        if (t0 < 0) {
            t0 = -t0;
        }
        if (t1 < 0) {
            t1 = -t1;
        }
        return t0 + t1;
    }


    public boolean isGoal() {
        return Arrays.deepEquals(tiles, goal);
    }

    public boolean equals(Object y) {
        return Arrays.deepEquals(tiles, (Object[]) y);
    }

    public Iterable<Board> neighbors() {
        return null;
    }

    public Board twin() {
        int d = dimension();
        int [][] arr = new int[d][d];
        int limit = d * d - 2;
        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length && k < limit; j++) {
                arr[i][j] = k++;
            }
        }
        arr[d - 1][d - 2] = k++;
        arr[d - 1][d - 1] = k;
        return new Board(arr);
    }
}
