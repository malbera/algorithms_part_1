package com.algorithms.part1.week1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double [] results;

    public PercolationStats(int n, int trials) {
        double [] results = new double[trials];
        for(int i=0; i<trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                percolation.open(row, col);
            }
            results[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
        this.results = results;
    }

    public double mean() {
        return StdStats.mean(results);
    }

    public double stddev() {
        return StdStats.stddev(results);
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev()) / Math.sqrt(results.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 * stddev()) / Math.sqrt(results.length);
    }

    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(StdIn.readInt(), StdIn.readInt());
        StdOut.println("mean\t= " + stats.mean());
        StdOut.println("stddev\t= " + stats.stddev());
        StdOut.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }

}
