package com.popcristianvlad.hackerrank.practice._30.days.of.code.day24;

import java.util.Scanner;

class Node4 {
    int data;
    Node4 next;

    Node4(int d) {
        data = d;
        next = null;
    }
}

public class Day24MoreLinkedLists {

    public static Node4 removeDuplicates(Node4 head) {
        if (head == null || head.next == null) {
            return head;
        }

        int lastData = head.data;
        Node4 prevNode = head;
        Node4 currentNode = head.next;

        while (currentNode != null) {
            if (currentNode.data == lastData) {
                prevNode.next = currentNode.next;
                currentNode = currentNode.next;
            } else {
                lastData = currentNode.data;
                currentNode = currentNode.next;
                prevNode = prevNode.next;
            }
        }

        return head;
    }

    public static Node4 insert(Node4 head, int data) {
        Node4 p = new Node4(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node4 start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(Node4 head) {
        Node4 start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node4 head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);
    }
}
