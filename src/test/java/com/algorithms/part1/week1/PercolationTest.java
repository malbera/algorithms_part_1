package com.algorithms.part1.week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PercolationTest {

    @Test
    void validateConstructor_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Percolation(0));
    }

    @Test
    void isOpen_shouldThrowException() {
        Percolation percolation = new Percolation(4);
        assertThrows(IllegalArgumentException.class, () -> percolation.isOpen(0, 0));
        assertThrows(IllegalArgumentException.class, () -> percolation.isOpen(0, -1));
        assertThrows(IllegalArgumentException.class, () -> percolation.isOpen(-1, -1));
        assertThrows(IllegalArgumentException.class, () -> percolation.isOpen(-1, 0));
    }

    @Test
    void open_shouldThrowException() {
        Percolation percolation = new Percolation(4);
        assertThrows(IllegalArgumentException.class, () -> percolation.open(0, 0));
    }

    @Test
    void isOpen_topPosition() {
        Percolation percolation = new Percolation(4);
        assertFalse(percolation.isOpen(1, 1));
        assertFalse(percolation.isFull(1, 1));
        percolation.open(1, 1);
        assertTrue(percolation.isOpen(1, 1));
        assertTrue(percolation.isFull(1, 1));
    }

    @Test
    void percolates() {
        Percolation percolation = new Percolation(2);
        assertFalse(percolation.percolates());
        percolation.open(1,1);
        percolation.open(2,1);
        assertTrue(percolation.percolates());
    }

    @Test
    void numberOfOpenSites() {
        Percolation percolation = new Percolation(4);
        assertEquals(0, percolation.numberOfOpenSites());
        percolation.open(1, 1);
        assertEquals(1, percolation.numberOfOpenSites());
        percolation.open(1, 1);
        assertEquals(1, percolation.numberOfOpenSites());
        percolation.open(1, 2);
        assertEquals(2, percolation.numberOfOpenSites());
    }

    @Test
    void open() {
        Percolation percolation = new Percolation(4);
        percolation.open(1,3);
        percolation.open(2,2);
        percolation.open(2,4);
        percolation.open(3,3);
        assertTrue(percolation.isFull(1, 3));
        assertFalse(percolation.isFull(2, 2));
        assertFalse(percolation.isFull(4, 2));
        assertFalse(percolation.isFull(3, 3));
        percolation.open(2,3);
        assertTrue(percolation.isFull(1, 3));
        assertTrue(percolation.isFull(2, 2));
        assertTrue(percolation.isFull(2, 4));
        assertTrue(percolation.isFull(3, 3));
        assertFalse(percolation.percolates());
        percolation.open(4,3);
        assertTrue(percolation.percolates());
    }

}
