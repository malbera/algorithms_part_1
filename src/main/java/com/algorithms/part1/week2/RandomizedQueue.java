package com.algorithms.part1.week2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private class Node<Item> {
        Node<Item> left;
        Node<Item> right;
        Item val;

        Node(Node<Item> node,
             Item item,
             boolean isFirst) {
            if (isFirst) {
                right = node;
                node.left = this;
            } else {
                left = node;
                node.right = this;
            }
            val = item;
        }

        Node(Item item) {
            val = item;
        }

        Node<Item> next(Node<Item> node, Item item) {
            return new Node<>(node, item, true);
        }

        Item remove() {
            if (left != null) {
                left.right = right;
            }
            if (right != null) {
                right.left = left;
            }
            return val;
        }

    }

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    public RandomizedQueue() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            first = new Node<>(item);
            last = first;
        } else {
            first = first.next(first, item);
        }
        size++;
    }

    public Item dequeue() {
        Node<Item> node = randomNode();
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
        return node.remove();
    }

    private Node<Item> randomNode() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int uniform = StdRandom.uniform(size);
        Node<Item> node;
        if (size / 2 <= uniform) {
            node = first;
            for(int i = 0; i < uniform; i++) {
                node = node.right;
            }
        } else {
            node = last;
            for(int i = size; i > uniform; i--) {
                node = node.left;
            }
        }
        return node;
    }


    public Item sample() {
        return randomNode().val;
    }

    public Iterator<Item> iterator() {

        RandomizedQueue<Item> iterator = new RandomizedQueue<>();
        Node<Item> first = this.first;
        while (first != null) {
            iterator.enqueue(first.val);
            first = first.right;
        }

        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return !iterator.isEmpty();
            }

            @Override
            public Item next() {
                return iterator.dequeue();
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}
