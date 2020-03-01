package com.algorithms.part1.week3;

import java.util.*;
import java.util.stream.Collectors;

public class FastCollinearPoints {

    private final Point[] points;

    public FastCollinearPoints(Point[] points) {
        validate(points);
        this.points = points.clone();
    }

    private void validate(Point[] points) {
        nullCheck(points);
        List<Point> repeated = new ArrayList<>();
        for (Point point : points) {
            nullCheck(point);
            for (Point repeatedPoint : repeated) {
                if (repeatedPoint.compareTo(point) == 0) {
                    throw new IllegalArgumentException();
                }
            }
            repeated.add(point);
        }
    }

    private void nullCheck(Object point) {
        if (point == null) {
            throw new IllegalArgumentException();
        }
    }

    public int numberOfSegments() {
        return segments().length;
    }

    public LineSegment[] segments() {
        Point [] aux = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            aux[i] = points[i];
        }
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            List<Entry> entries = new ArrayList<>();
            Point currentPoint = points[i];
            Arrays.sort(aux, currentPoint.slopeOrder().thenComparing(Point::compareTo));
            for (int j = 1; j < aux.length; j++) {
                double tSlope = currentPoint.slopeTo(aux[j]);
                entries.add(new Entry(tSlope, aux[j]));
            }
            entries.stream().collect(Collectors.groupingBy(Entry::getSlope))
                    .values().stream()
                    .filter(v -> v.size() >= 3)
                    .map(v -> createLineSegment(currentPoint, v))
                    .filter(s -> checkDuplicates(s, lines))
                    .forEach(lines::add);
        }
        return lines.stream().map(l -> new LineSegment(l.p, l.q))
                .collect(Collectors.toList())
                .toArray(new LineSegment[lines.size()]);
    }

    private boolean checkDuplicates(Line s, List<Line> lines) {
        return lines.stream().noneMatch(l -> l.same(s));
    }

    private Line createLineSegment(Point point,
                                   List<Entry> adjacent) {
        Point first = adjacent.get(0).getPoint();
        Point last = adjacent.get(adjacent.size() - 1).getPoint();
        if (point.compareTo(first) < 0) {
            return new Line(point, last);
        } else if (point.compareTo(last) > 0) {
            return new Line(first, point);
        }
        return new Line(first, last);
    }

    private static class Line {
        private final Point p;
        private final Point q;

        private Line(Point p, Point q) {
            this.p = p;
            this.q = q;
        }

        boolean same(Line l) {
            return this.p.compareTo(l.p) == 0 &&
                    this.q.compareTo(l.q) == 0;
        }
    }

    private static class Entry {
        private final double slope;
        private final Point point;

        private Entry(double slope, Point point) {
            this.slope = slope;
            this.point = point;
        }

        private double getSlope() {
            return slope;
        }

        private Point getPoint() {
            return point;
        }
    }
}
