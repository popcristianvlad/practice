package com.popcristianvlad.hackerrank.practice._30.days.of.code.day15;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Day15LinkedList {

    public static Node insert(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }

        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(data);

        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
        sc.close();
    }
}
