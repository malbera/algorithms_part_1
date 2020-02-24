package com.algorithms.part1.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

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

        Node<Item> prev(Node<Item> node, Item item) {
            return new Node<>(node, item, false);
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

    public Deque() {
    }

    private Deque(Node<Item> first,
          Node<Item> last,
          int size) {
        this.first = first;
        this.last = last;
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
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

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            last = new Node<>(item);
            first = last;
        } else {
            last = last.prev(last, item);
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Node<Item> old = first;
            first = first.right;
            if (first == null) {
                last = null;
            }
            size--;
            return old.remove();
        }
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Node<Item> old = last;
            last = last.left;
            if (last == null) {
                first = null;
            }
            size--;
            return old.remove();
        }
    }

    public Iterator<Item> iterator() {
        Deque<Item> iterator = new Deque<>();
        Node<Item> first = this.first;
        while (first != null) {
            iterator.addLast(first.val);
            first = first.right;
        }
        return new Iterator<Item>() {

            @Override
            public boolean hasNext() {
                return !iterator.isEmpty();
            }

            @Override
            public Item next() {
                return iterator.removeFirst();
            }
        };
    }



    public static void main(String[] args) {
    }

}
