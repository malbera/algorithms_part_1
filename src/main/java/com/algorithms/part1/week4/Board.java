package com.algorithms.part1.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private int[][] tiles;
    private static final int[][] MOVES = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

    public Board(int[][] tiles) {
        this.tiles = deepCopy(tiles);
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
        int inc = 1;
        int limit = tiles.length * tiles.length;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length && inc < limit; j++) {
                if (tiles[i][j] != inc++) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.deepEquals(tiles, board.tiles);
    }

    public Iterable<Board> neighbors() {
        int x0 = -1;
        int y0 = -1;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] == 0) {
                    x0 = i;
                    y0 = j;
                    i = tiles.length;
                    break;
                }
            }
        }
        List<Board> neighbors = new ArrayList<>();
        for (int[] move : MOVES) {
            int x1 = x0 + move[0];
            int y1 = y0 + move[1];
            if (x1 >= 0 && x1 < tiles.length && y1 >= 0 && y1 < tiles.length) {
                int[][] copy = deepCopy(tiles);
                swap(copy, x0, y0, x1, y1);
                neighbors.add(new Board(copy));
            }
        }
        return neighbors;
    }

    public Board twin() {
        int[][] clone = deepCopy(tiles);
        if (clone[0][0] == 0) {
            swap(clone, 1, 0, 1, 1);
        } else if (clone[0][1] == 0) {
            swap(clone, 1, 0, 1, 1);
        } else {
            swap(clone, 0, 0, 0, 1);
        }
        return new Board(clone);
    }

    private void swap(int[][] arr, int x0, int y0, int x1, int y1) {
        int t = arr[x0][y0];
        arr[x0][y0] = arr[x1][y1];
        arr[x1][y1] = t;
    }

    private int[][] deepCopy(int[][] arr) {
        int[][] result = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }
}
