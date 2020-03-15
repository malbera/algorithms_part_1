package com.algorithms.part1.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PointSET {

    private final Set<Point2D> points;

    public PointSET() {
        this.points = new TreeSet<>();
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }

    public int size() {
        return points.size();
    }

    public void insert(Point2D p) {
        validate(p);
        points.add(p);
    }
    public boolean contains(Point2D p) {
        validate(p);
        return points.contains(p);
    }

    public void draw() {
    }

    public Iterable<Point2D> range(RectHV rect) {
        validate(rect);
        return points.stream()
                .filter(rect::contains)
                .collect(Collectors.toList());
    }

    public Point2D nearest(Point2D p) {
        validate(p);
        Comparator<Point2D> distanceTo = p.distanceToOrder();
        return points.stream().min(distanceTo)
                .orElse(null);
    }

    private void validate(Object toValidate) {
        if (toValidate == null) {
            throw new IllegalArgumentException();
        }
    }

}
