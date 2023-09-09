package com.popcristianvlad.hackerrank.practice._30.days.of.code.day23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node3 {
    Node3 left, right;
    int data;

    Node3(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Day23BSTLevelOrderTraversal {

    static List<Node3> queue = new ArrayList<>();

    static void enqueue(Node3 node) {
        queue.add(node);
    }

    static Node3 dequeue() {
        return queue.remove(0);
    }

    static void levelOrder(Node3 root) {
        enqueue(root);

        while (!queue.isEmpty()) {
            Node3 currentNode = dequeue();
            System.out.print(currentNode.data + " ");
            if (currentNode.left != null) {
                enqueue(currentNode.left);
            }

            if (currentNode.right != null) {
                enqueue(currentNode.right);
            }
        }
    }

    public static Node3 insert(Node3 root, int data) {
        if (root == null) {
            return new Node3(data);
        } else {
            Node3 cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node3 root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}
