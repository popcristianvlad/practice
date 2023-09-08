package com.popcristianvlad.leetcode.practice;

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}

public class P21MergeTwoSortedLists {

    public static ListNode2 mergeTwoLists(ListNode2 list1, ListNode2 list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode2 mergedList = list1.val < list2.val ? new ListNode2(list1.val) : new ListNode2(list2.val);
        ListNode2 mergedListCurrentNode = mergedList;

        if (list1.val < list2.val) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            mergedListCurrentNode.next = list1.val < list2.val ? new ListNode2(list1.val) : new ListNode2(list2.val);
            mergedListCurrentNode = mergedListCurrentNode.next;
            if (list1.val < list2.val) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            mergedListCurrentNode.next = new ListNode2(list1.val);
            mergedListCurrentNode = mergedListCurrentNode.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            mergedListCurrentNode.next = new ListNode2(list2.val);
            mergedListCurrentNode = mergedListCurrentNode.next;
            list2 = list2.next;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        ListNode2 list1 = new ListNode2(1, new ListNode2(2, new ListNode2(4, null)));
        ListNode2 list2 = new ListNode2(1, new ListNode2(3, new ListNode2(4, null)));

        ListNode2 mergedList = mergeTwoLists(list1, list2);
    }
}
