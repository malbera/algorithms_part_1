package com.algorithms.part1.week3;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point that) {
        if (isSamePoint(that)) {
            return 0;
        }
        if (that.y > y || (y == that.y && that.x > x)) {
            return -1;
        }
        return 1;
    }

    public double slopeTo(Point that) {
        if (isSamePoint(that)) {
            return Double.NEGATIVE_INFINITY;
        }
        if (isHorizontalLine(that)) {
            return 0d;
        }
        if (isVerticalLine(that)) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) (that.y - y) / (that.x - x);
    }

    public Comparator<Point> slopeOrder() {
        return Comparator.comparingDouble(this::slopeTo);
    }

    private boolean isVerticalLine(Point point) {
        return x == point.x;
    }

    private boolean isHorizontalLine(Point point) {
        return y == point.y;
    }

    private boolean isSamePoint(Point point) {
        return x == point.x && y == point.y;
    }


    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public void draw() {
        StdDraw.point(x, y);
    }
}
