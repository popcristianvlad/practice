package com.popcristianvlad.hackerrank.practice.algorithms.graph.theory.EvenTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenTree {

    static class Node {
        int value;
        Node parent;
        int numberOfDirectChilds;

        public Node(int value, Node parent) {
            this.parent = parent;
            this.value = value;
        }
    }

    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        int numberOfCuts = 0;

        List<Node> nodes = new ArrayList<>();
        Node root = new Node(1, null);
        nodes.add(root);

        for (int i = 0; i < t_edges; i++) {
            Node parentNode = nodes.get(t_to.get(i) - 1);
            Node currentNode = new Node(t_from.get(i), parentNode);
            updateNumberOfChilds(parentNode);
            nodes.add(currentNode);
        }

        for (int i = 1; i < t_nodes; i++) {
            if (nodes.get(i).numberOfDirectChilds % 2 == 1) {
                numberOfCuts++;
            }
        }

        return numberOfCuts;
    }

    static void updateNumberOfChilds(Node parentNode) {
        while (parentNode != null) {
            parentNode.numberOfDirectChilds++;
            parentNode = parentNode.parent;
        }
    }

    public static void main(String[] args) {
        int t_nodes = 10;
        int t_edges = 9;

        List<Integer> t_from = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> t_to = Arrays.asList(1, 1, 3, 2, 1, 2, 6, 8, 8);

        System.out.println(evenForest(t_nodes, t_edges, t_from, t_to));

        t_nodes = 20;
        t_edges = 19;

        t_from = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        t_to = Arrays.asList(1, 1, 3, 2, 5, 1, 1, 2, 7, 10, 3, 7, 8, 12, 6, 6, 10, 1, 8);

        System.out.println(evenForest(t_nodes, t_edges, t_from, t_to));

        t_nodes = 30;
        t_edges = 29;

        t_from = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        t_to = Arrays.asList(1, 2, 3, 2, 4, 4, 1, 5, 4, 4, 8, 2, 2, 8, 10, 1, 17, 18, 4, 15, 20, 2, 12, 21, 17, 5, 27, 4, 25);

        System.out.println(evenForest(t_nodes, t_edges, t_from, t_to));
    }
}
