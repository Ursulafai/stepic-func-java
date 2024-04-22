package algorithms.books;

import algorithms.leetcode.structures.ListNode;

import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        int[] array = new int[] {-5, 2, 10, 4, 5};

//        ListNode node5 = new ListNode(5, null);
//        ListNode node4 = new ListNode(4, node5);
//        ListNode node3 = new ListNode(3, node4);
//        ListNode node2 = new ListNode(2, node3);
//        ListNode node1 = new ListNode(1, node2);
        System.out.println(max(array));
    }

    static int sum(int[] array) {
        if (array.length == 0) return 0;

        int i = array[0];
        return i + sum(Arrays.copyOfRange(array, 1, array.length));
    }

    static int count(ListNode head) {
        if (head == null) return 0;

        return 1 + count(head.next);
    }

    static int max(int[] array) {
        if (array.length == 2) return Math.max(array[0], array[1]);

        int tmpMax = max(Arrays.copyOfRange(array, 1, array.length));
        return Math.max(array[0], tmpMax);
    }
}