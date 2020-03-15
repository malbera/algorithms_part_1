package com.algorithms.part1.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;
import java.util.List;

public class KdTree {

    private Node root;

    public KdTree() {
    }

    public boolean isEmpty() {
        return root == null || root.size == 0;
    }

    public int size() {
        if (root == null) {
            return 0;
        }
        return root.size;
    }

    public void insert(Point2D p) {
        validate(p);
        if (root == null) {
            root = new Node(1, null, null, true, p);
        } else {
            root.put(p);
        }
    }
    public boolean contains(Point2D p) {
        validate(p);
        if (root == null) {
            return false;
        } else {
            return root.find(p);
        }
    }

    public void draw() {
    }

    public Iterable<Point2D> range(RectHV rect) {
        validate(rect);
        if (root == null) {
            return null;
        } else {
            return root.range(rect);
        }
    }

    public Point2D nearest(Point2D p) {
        validate(p);
        if (isEmpty()) {
            return null;
        } else {
            return root.nearest(p);
        }
    }

    private void validate(Object toValidate) {
        if (toValidate == null) {
            throw new IllegalArgumentException();
        }
    }

    private class Node {

        private int size;
        private Node left;
        private Node right;
        private boolean vertical;
        private Point2D val;

        private Node(int size,
                     Node left,
                     Node right,
                     boolean vertical,
                     Point2D val) {
            this.size = size;
            this.left = left;
            this.right = right;
            this.vertical = vertical;
            this.val = val;
        }


        private void put(Point2D point) {
            boolean result = put(point, this);
            if (result) {
                size++;
            }
        }

        private boolean put(Point2D point,
                        Node parent) {
            if (eq(point, parent.val)) {
                return false;
            }
            Point2D val = parent.val;
            if (parent.vertical) {
                if (val.x() > point.x()) {
                    if (parent.left == null) {
                        parent.left = new Node(0, null, null, false, point);
                        return true;
                    } else {
                        return put(point, parent.left);
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = new Node(0, null, null, false, point);
                        return true;
                    } else {
                        return put(point, parent.right);
                    }
                }
            } else {
                if (val.y() > point.y()) {
                    if (parent.right == null) {
                        parent.right = new Node(0, null, null, true, point);
                        return true;
                    } else {
                        return put(point, parent.right);
                    }
                } else {
                    if (parent.left == null) {
                        parent.left = new Node(0, null, null, true, point);
                        return true;
                    } else {
                        return put(point, parent.left);
                    }
                }
            }
        }

        private boolean find(Point2D point) {
            if (eq(val, point)) {
                return true;
            } else {
                if (vertical) {
                    if (val.x() > point.x()) {
                        return left != null && left.find(point);
                    } else {
                        return right != null && right.find(point);
                    }
                } else {
                    if (val.y() > point.y()) {
                        return right != null && right.find(point);
                    } else {
                        return left != null && left.find(point);
                    }
                }
            }
        }

        private Point2D nearest(Point2D point) {
            if (eq(val, point)) {
                return val;
            } else {
                if (vertical) {
                    if (val.x() > point.x()) {
                        return left == null ? val : left.nearest(point);
                    } else {
                        return right == null ? val : right.nearest(point);
                    }
                } else {
                    if (val.y() > point.y()) {
                        return right == null ? val : right.nearest(point);
                    } else {
                        return left == null ? val : left.nearest(point);
                    }
                }
            }
        }

        private boolean eq(Point2D a, Point2D b) {
            return a.compareTo(b) == 0;
        }

        public Iterable<Point2D> range(RectHV rect) {
            List<Point2D> result = new ArrayList<>();
            range(result, rect, this);
            return result;
        }

        private void range(List<Point2D> points,
                           RectHV rect,
                           Node node) {
            if (node == null) {
                return;
            }
            if (rect.contains(node.val)) {
                points.add(node.val);
            }
            if (node.vertical) {
                if (rect.xmin() <= node.val.x()) {
                    range(points, rect, node.left);
                }
                if (rect.xmax() >= node.val.x()) {
                    range(points, rect, node.right);
                }
            } else {
                if (rect.ymin() <= node.val.y()) {
                    range(points, rect, node.right);
                }
                if (rect.ymax() >= node.val.y()) {
                    range(points, rect, node.left);
                }
            }
        }
    }

}
