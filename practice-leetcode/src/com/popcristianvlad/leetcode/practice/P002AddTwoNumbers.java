package com.popcristianvlad.leetcode.practice;

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class P02AddTwoNumbers {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode((l1.val + l2.val) % 10, null);
        ListNode sum = root;
        int carryOver = (l1.val + l2.val) / 10;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            sum.next = new ListNode((l1.val + l2.val + carryOver) % 10, null);
            carryOver = (l1.val + l2.val + carryOver) / 10;
            l1 = l1.next;
            l2 = l2.next;
            sum = sum.next;
        }

        if (l1 == null && l2 == null & carryOver > 0) {
            sum.next = new ListNode(carryOver, null);
        } else if (l1 != null) {
            while (l1 != null) {
                sum.next = new ListNode((l1.val + carryOver) % 10, null);
                carryOver = (l1.val + carryOver) / 10;
                l1 = l1.next;
                sum = sum.next;
            }

            if (carryOver > 0) {
                sum.next = new ListNode(carryOver, null);
            }
        } else if (l2 != null) {
            while (l2 != null) {
                sum.next = new ListNode((l2.val + carryOver) % 10, null);
                carryOver = (l2.val + carryOver) / 10;
                l2 = l2.next;
                sum = sum.next;
            }

            if (carryOver > 0) {
                sum.next = new ListNode(carryOver, null);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        ListNode sum = addTwoNumbers(node1, node2);

        System.out.println(sum);

        node1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))));
        node2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));

        sum = addTwoNumbers(node1, node2);

        System.out.println(sum);

        node1 = new ListNode(3, new ListNode(7, null));
        node2 = new ListNode(9, new ListNode(2, null));

        sum = addTwoNumbers(node1, node2);

        System.out.println(sum);
    }
}
