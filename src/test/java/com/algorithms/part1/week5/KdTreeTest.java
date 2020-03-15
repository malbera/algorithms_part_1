package com.algorithms.part1.week5;

import edu.princeton.cs.algs4.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KdTreeTest {

    @Test
    void put() {
        KdTree kdTree = new KdTree();
        assertTrue(kdTree.isEmpty());
        kdTree.insert(new Point2D(0.1, 0.5));
        assertFalse(kdTree.isEmpty());
        assertEquals(1, kdTree.size());
        kdTree.insert(new Point2D(0.2, 0.5));
        assertEquals(2, kdTree.size());
        kdTree.insert(new Point2D(0.1, 0.5));
        assertEquals(2, kdTree.size());
    }

    @Test
    void find() {
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(0.7, 0.2));
        kdTree.insert(new Point2D(0.5, 0.4));
        kdTree.insert(new Point2D(0.2, 0.3));
        kdTree.insert(new Point2D(0.4, 0.7));
        kdTree.insert(new Point2D(0.9, 0.6));
        assertTrue(kdTree.contains(new Point2D(0.5, 0.4)));
    }

    @Test
    void nearest() {
        Point2D point = new Point2D(0.2, 0.5);
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(0.9, 0.5));
        kdTree.insert(point);
        kdTree.insert(new Point2D(0.3, 0.5));
        kdTree.insert(new Point2D(0.4, 0.5));

        Point2D nearest = kdTree.nearest(new Point2D(0.1, 0.5));

        assertEquals(-1, point.compareTo(nearest));
    }

    @Test
    void range() {
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(0.25, 0.25));
        kdTree.insert(new Point2D(0.0, 0.5));
        kdTree.insert(new Point2D(0.0, 0.0));
        kdTree.insert(new Point2D(0.0, 0.0));

        assertEquals(3, kdTree.size());

    }
}
