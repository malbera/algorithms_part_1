package com.algorithms.part1.week2;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void addRemoveItems() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.addFirst("d");
        deque.addFirst("e");
        assertEquals("a", deque.removeLast());
        assertEquals("b", deque.removeLast());
        assertEquals("c", deque.removeLast());
        assertEquals("d", deque.removeLast());
        assertEquals("e", deque.removeLast());
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    void iteratorTest() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("a");
        deque.addFirst("b");
        Iterator<String> iterator = deque.iterator();
        assertEquals("b", iterator.next());
        assertEquals("a", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void sequence() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(1);
        rq.enqueue(9);
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        assertTrue(rq.isEmpty());
    }

}
