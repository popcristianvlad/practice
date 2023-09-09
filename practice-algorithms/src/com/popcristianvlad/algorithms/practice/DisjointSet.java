package com.popcristianvlad.algorithms.practice;

class DisjointUnionSets {

    private int n;
    private int[] rank;
    private int[] parent;

    public DisjointUnionSets(int n) {
        this.n = n;
        this.rank = new int[n];
        this.parent = new int[n];
        makeSet();
    }

    private void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}

public class DisjointSet {

    public static void main(String[] args) {
        DisjointUnionSets dus = new DisjointUnionSets(5);
        dus.union(0, 2);
        dus.union(4, 2);
        dus.union(3, 1);

        System.out.print("4,2: ");
        if (dus.find(4) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.print("1,0: ");
        if (dus.find(1) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
